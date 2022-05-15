package entity;

public class User {
    private String natId;
    private String name;
    private String address;
    private String phone;
    private String city;

    public User(String natId, String name, String address, String phone, String city) {
        this.natId = natId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

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
