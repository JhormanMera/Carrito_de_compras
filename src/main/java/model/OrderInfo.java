package model;

import entity.Order;
import entity.Product;

import java.util.ArrayList;

public class OrderInfo {

    private int orderID;
    private ArrayList <Product> products;

    private int amount;

    private int totalprice;

    public OrderInfo(int orderID, ArrayList<Product> products,int amount, int totalprice) {
        this.orderID = orderID;
        this.products = products;
        this.amount=amount;
        this.totalprice = totalprice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOrder(int order) {
        this.orderID = order;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public int getOrder() {
        return orderID;
    }
    public ArrayList<?> getProducts() {
        return products;
    }
}
