package model;

import entity.Order;

import java.util.ArrayList;

public class OrderInfo {

    private Order order;
    private ArrayList <?> products;
    public OrderInfo( Order order, ArrayList<?> products) {
        this.order=order;
    }
    public Order getOrder() {
        return order;
    }
    public ArrayList<?> getProducts() {
        return products;
    }
}
