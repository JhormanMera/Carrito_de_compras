package model;

public class ModifyOrder {

    private int orderID;
    private int productID;
    private int amount;

    public ModifyOrder(int orderID, int productID, int amount) {
        this.orderID = orderID;
        this.productID = productID;
        this.amount = amount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
