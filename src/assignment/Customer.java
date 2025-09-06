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
    
    public void showActiveVouchers() {
        System.out.println("\nYour Active Vouchers:");
        int i = 0;
        for (Voucher v : activeVouchers) {
            if(!v.isUsed()){
                System.out.println((i+1) + ". " + v.getTitle() + " [Code: " + v.getCode() + "]");
                i++;
            }    
        }
        if (i == 0) {
            System.out.println(" - (none) -");
        }
    }

    public void showAvailableVouchers(List<Voucher> allVouchers) {
        System.out.println("\nAvailable Vouchers:");
        for (int i = 0; i < allVouchers.size(); i++) {
            Voucher v = allVouchers.get(i);
            System.out.println((i+1) + ". " + v.getCode() + ": "+ v.getTitle() + " (Cost: " + v.getPointRequired() + " points)");
        }
    }

    public void redeemVoucher(int option, List<Voucher> allVouchers) {
        if (option < 1 || option > allVouchers.size()) {
            System.out.println("Invalid option.");
            return;
        }
        Voucher selected = allVouchers.get(option-1);

        if (rewardPoints >= selected.getPointRequired()) {
            rewardPoints -= selected.getPointRequired();
            activeVouchers.add(new Voucher(
                selected.getCode(), 
                selected.getTitle(), 
                selected.getPointRequired(), 
                selected.getDiscountAmount()
            ));
            System.out.println("Redeemed Successfully! Voucher Code: " + selected.getCode());
        } else {
            System.out.println("Not enough points. Needed: " + selected.getPointRequired() + 
                               ", You have: " + rewardPoints);
        }
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

