package openended;

public class User {
    private String id, name, address;
    public User(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public String getName(){
        return name;
    }
}
