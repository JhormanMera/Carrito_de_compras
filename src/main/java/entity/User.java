package entity;

public class User {
    String natId;

    public User(String natId) {
        this.natId = natId;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }
}
