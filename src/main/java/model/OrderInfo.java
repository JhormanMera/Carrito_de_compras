package model;

import java.util.ArrayList;

public class OrderInfo {
    private int amount;
    private int totalPrice;
    private ArrayList <?> products;
    public OrderInfo(int amount, int totalPrice, ArrayList<?> products) {
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.products = products;
    }
    public int getAmount() {
        return amount;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public ArrayList<?> getProducts() {
        return products;
    }
}
