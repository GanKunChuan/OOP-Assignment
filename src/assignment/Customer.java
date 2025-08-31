package assignment;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private String UserID;
    private String IC;
    private String phoneNo;
    private char gender;
    private int rewardPoints;
    private List<Voucher> activeVouchers = new ArrayList<>();
    
    public Customer(String name, String email, String IC, String phoneNo, char gender, String password){
        super(name, email, password, "customer");
        this.IC = IC;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.rewardPoints = 0;
    }
    
    public Voucher findActiveVoucher(String code){
        for(Voucher v: activeVouchers){
            if(!v.isUsed() && v.getCode().equals(code))
                return v;
        }
        return null;
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

    public List<Voucher> getActiveVouchers() {
        return activeVouchers;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints += rewardPoints;
    }
    
}

