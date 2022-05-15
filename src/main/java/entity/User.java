package entity;

public class User {
    private String natId;

    public User(String natId) {
        this.natId = natId;
    }

    public User( ) {    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }
}
