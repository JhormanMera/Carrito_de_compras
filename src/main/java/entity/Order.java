package entity;

public class Order {
    private int id;
    private int payed;
    private long creationDate;
    private long paymentDate;
    private String userId;
    private int productsAmount;
    private double totalPrice;

    public Order(int id, int payed, long creationDate, long paymentDate, String userId, int productsAmount, double totalPrice) {
        this.id = id;
        this.payed = payed;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.userId = userId;
        this.productsAmount = productsAmount;
        this.totalPrice = totalPrice;
    }

    public int getProductsAmount() {
        return productsAmount;
    }

    public void setProductsAmount(int productsAmount) {
        this.productsAmount = productsAmount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(long paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
