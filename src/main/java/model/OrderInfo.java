package model;

import java.util.ArrayList;

public class OrderInfo {
    private int amount;
    private int totalPrice;
    private ArrayList <?> orders;

    public OrderInfo(int amount, int totalPrice, ArrayList<?> orders) {
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.orders = orders;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<?> getOrders() {
        return orders;
    }
}
