package entity;

public class Order {
    private int id;
    private boolean payed;
    private long creationDate;
    private long paymentDate;
    private String userId;

    public Order(int id, boolean payed, long creationDate, long paymentDate, String userId) {
        this.id = id;
        this.payed = payed;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
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
