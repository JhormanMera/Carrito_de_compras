package provider;

import db.DbConnection;
import entity.Order;
import entity.Product;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProvider {

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        DbConnection conn = new DbConnection();
        String sql="INSERT INTO usersA00369206 (natID) VALUES ('$USERID')";
        sql= sql.replace("$USERID",user.getNatId());
        conn.runQuery(sql);
        conn.close();
    }

    public ArrayList<Order> getOrdersHistory(String natID) throws SQLException, ClassNotFoundException {

        DbConnection conn = new DbConnection();

        String sql = "SELECT ordersA00369206.id, ordersA00369206.creationDate, ordersA00369206.paymentDate FROM ordersA00369206 WHERE ordersA00369206.userID = '$ORDERID'" ;

        sql = sql.replace("$ORDERID",natID);
        ResultSet results =  conn.getData(sql);
        ArrayList<Order> orders = new ArrayList<>();

        while(results.next()){
            int payed=0;
            int id = results.getInt("id");

            String creationDate  = results.getString("creationDate");

            String paymentDate = results.getString("paymentDate");

            if(!paymentDate.equals("0")){
                payed=1;
            }

            Order order = new Order(id, payed, Long.parseLong(creationDate), Long.parseLong(paymentDate), natID);
            orders.add(order);
        }
        conn.close();
        return orders;

    }
}
