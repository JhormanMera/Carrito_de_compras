package provider;

import db.DbConnection;
import entity.Order;
import entity.Product;
import model.OrderInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


public class OrderProvider {

    public void addOrder(Order order) throws SQLException, ClassNotFoundException {
        DbConnection conn = new DbConnection();
        String sql="INSERT INTO ordersA00369206 (creationDate, userID) VALUES ($CREATIONDATE,'$USERID')";
        sql= sql.replace("$CREATIONDATE", Long.toString(new Date().getTime()));
        sql = sql.replace("$USERID", order.getUserId());
        conn.runQuery(sql);
        conn.close();
    }

    public Order updateStatus(String info) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        String sql="UPDATE ordersA00369206 SET payed = 1 WHERE id = $ID";

        long time = System.currentTimeMillis();

        sql = sql.replace("$ID", info);
        conn.runQuery(sql);

        sql = "UPDATE ordersA00369206 SET paymentDate = '$PAY' WHERE id = $ID";

        sql = sql.replace("$ID", info);
        sql = sql.replace("$PAY", Long.toString(time));
        conn.runQuery(sql);

        sql = "SELECT * FROM ordersA00369206 WHERE id = $ID AND paymentDate = $PAYDATE";
        sql = sql.replace("$ID", info);
        sql = sql.replace("$PAYDATE", Long.toString(time));

        //ArrayList<Order> orders = new ArrayList<>();
        Order order=new Order();
        ResultSet results =  conn.getData(sql);

        while(results.next()){

            int id = results.getInt("id");

            int payed = results.getInt("payed");

            String creationDate = results.getString("creationDate");

            String paymentDate = results.getString("paymentDate");

            String userId = results.getString("userID");

            order = new Order(id, payed, Long.parseLong(creationDate),Long.parseLong(paymentDate), userId);

        }
        conn.close();
        return order;
    }

    public void addProductToOrder(OrderChange order) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        ProductProvider provider = new ProductProvider();

        String sql="INSERT INTO orders_productsA00369206 (orderID, productID,Amount) VALUES ('$ORDERID','$PRODUCTID','$QUANTITY')";

        //sql= sql.replace("$ORDERID", order.getOrderId());
        //sql = sql.replace("$QUANTITY", Integer.toString(order.getQuantity()));
        //int id = provider.findProductId(order.getProductName());

        sql = sql.replace("$PRODUCTID", "");
        conn.runQuery(sql);
        conn.close();
    }

    public void deleteProductFromOrder(String[] parts) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        String productName = parts[1];
        
        ProductProvider provider = new ProductProvider();

        String sql="DELETE FROM orders_productsA00369206 WHERE orderId = $ORRDERID AND productId = $PRODUCTID";
        sql= sql.replace("$ORRDERID", parts[0]); //Hacer cambio a time unix
        int id = provider.findProductId(productName);

        if(id==0){
            conn.close();
            return;
        }else{
            sql = sql.replace("$PRODUCTID", Integer.toString(id));
            conn.runQuerry(sql);
            conn.close();
        }
    }

    public void removeProductFromOrder(OrderChange order) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        ProductProvider provider = new ProductProvider();

        String sql="UPDATE orders_productsA00369206 SET quantity = $QUANTITY WHERE orderId = $ORDERID AND productId = $PRODUCTID";
        sql= sql.replace("$ORDERID",  Integer.toString(order.getOrderId())); //Hacer cambio a time unix
        sql = sql.replace("$QUANTITY",    Integer.toString(order.getQuantity()));
        int id = provider.findProductId(order.getProductName());

        if(id==0){
            conn.close();
            return;
        }else {

            sql = sql.replace("$PRODUCTID", Integer.toString(id));
            System.out.println(sql);
            conn.runQuerry(sql);
            conn.close();
        }
    }

    public OrderInfo getInfoFromOrder(String info) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        String sql = "SELECT productsA00369206.id, productsA00369206.name, productsA00369206.price, ordersA00369206.id, orders_productsA00369206.amount FROM (productsA00369206 INNER JOIN orders_productsA00369206" +
                "ON productsA00369206.id = orders_productsA00369206.productID)INNER JOIN ordersA00369206 ON orders_productsA00369206.orderID = ordersA00369206.id WHERE ordersA00369206.id = $ORDERID";
        sql = sql.replace("$ORDERID", info);
        ArrayList<Product> products = new ArrayList<>();
        int totalPrice=0;
        int totalAmount=0;
        ResultSet results =  conn.getData(sql);

        while(results.next()){

            int id = results.getInt("id");

            String name = results.getString("name");

            int price = results.getInt("price");

            int amount = results.getInt("amount");

            totalAmount+=amount;
            totalPrice+=price;

            Product product = new Product(id,name,amount,price);
            products.add(product);
        }

        OrderInfo answer = new OrderInfo(Integer.parseInt(info),products,totalAmount,totalPrice);

        conn.close();
        return answer;

    }
}

