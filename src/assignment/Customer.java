package assignment;

public class Customer extends User{
    private String UserID;
    private String IC;
    private String phoneNo;
    private char gender;
    private int rewardPoints;
    
    public Customer(String name, String email, String IC, String PhoneNo, char gender, String password){
        super(name, email, password, "customer");
        this.IC = IC;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.rewardPoints = 0;
    }
}
