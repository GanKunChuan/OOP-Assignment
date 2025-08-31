package assignment;

public class Admin extends User{
    private Bicycle bicycle;
    
    public Admin(String name, String email, String password) {
        super(name, email, password, "admin");
    }
}
