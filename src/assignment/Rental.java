package assignment;

import java.util.Date;

public class Rental {
    private String rentalID;
    private Date startTime;
    private String rentalType;
    private double deposit;
    private Customer customer;
    private Bicycle bicycle;

    public Rental(String rentalID, String rentalType, double deposit, Customer customer, Bicycle bicycle) {
        this.rentalID = rentalID;
        this.startTime = new Date(); //get current date and time
        this.rentalType = rentalType;
        this.deposit = deposit;
        this.customer = customer;
        this.bicycle = bicycle;
    }
    
    
}
