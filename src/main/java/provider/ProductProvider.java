package provider;

import db.DbConnection;
import entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductProvider {

    public void addProduct(Product product) throws SQLException, ClassNotFoundException {
        DbConnection conn = new DbConnection();

        String sql="INSERT INTO productsA00369206(name,amount,price) VALUES ('$NAME','$AMOUNT','$PRICE')";
        sql= sql.replace("$NAME",product.getName());
        sql= sql.replace("$AMOUNT",Integer.toString(product.getAmount()));
        sql = sql.replace("$PRICE", Double.toString(product.getPrice()));
        conn.runQuery(sql);
        conn.close();
    }
    public int searchForProductId(String name) throws SQLException, ClassNotFoundException {
        DbConnection conn = new DbConnection();

        String sql="SELECT id FROM productsA00369206 WHERE name = '$NAME'";
        sql = sql.replace("$NAME", name);
        ResultSet results =  conn.getData(sql);
        int id = 0;
        while(results.next()) {
            id= results.getInt("id");
        }
        conn.close();
        return id;
    }

}