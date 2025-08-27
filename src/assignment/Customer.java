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

    public String getUserID() {
        return UserID;
    }

    public String getIC() {
        return IC;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public char getGender() {
        return gender;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    
    
}
