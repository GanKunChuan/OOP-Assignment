package assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rental {
    private static int nextRentalNum = 1;
    private String rentalID;
    private String rentalType;
    private LocalDateTime startTime;
    private static double deposit = 30.00;
    private boolean active;
    private Customer customer;
    private Bicycle bicycle;

    public Rental(String rentalType, LocalDateTime startTime, Customer customer, Bicycle bicycle) {
        this.rentalID = String.format("R%03d", nextRentalNum++);
        this.rentalType = rentalType;
        this.startTime = startTime;
        this.customer = customer;
        this.bicycle = bicycle;
        this.active = true;
    }

    public static int getNextRentalNum() {
        return nextRentalNum;
    }

    public String getRentalID() {
        return rentalID;
    }

    public String getRentalType() {
        return rentalType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public static double getDeposit() {
        return deposit;
    }

    public boolean isActive() {
        return active;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                
        return "Rental ID    : " + rentalID + 
                "\nType         : " + bicycle.getType() +
                "\nBrand        : " + bicycle.getBrand() +
                "\nModel        : " + bicycle.getModel() +
                "\nColor        : " + bicycle.getColor() +
                "\nRental Type  : " + rentalType +
                "\nStart Time   : " + startTime.format(formatter) ;
    }
   
}

