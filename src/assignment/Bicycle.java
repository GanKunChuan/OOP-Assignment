package assignment;

public class Bicycle {
    private String BicycleID;
    private String type;
    private String brand;
    private String model;
    private String color;
    private double RatePerHour;
    private double RatePerDay;
    private int quantity;
    private boolean underMaintenance;

    // Constructor
    public Bicycle(String BicycleID, String type, String brand, String model, String color, double RatePerHour, double RatePerDay, int quantity, boolean underMaintenance) {
        this.BicycleID = BicycleID;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.RatePerHour = RatePerHour;
        this.RatePerDay = RatePerDay;
        this.quantity = quantity;
        this.underMaintenance = underMaintenance;
    }

    // getter & setter
    public String getBicycleID() {
        return BicycleID;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getRatePerHour() {
        return RatePerHour;
    }

    public double getRatePerDay() {
        return RatePerDay;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public void setBicycleID(String BicycleID) {
        this.BicycleID = BicycleID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRatePerHour(double RatePerHour) {
        this.RatePerHour = RatePerHour;
    }

    public void setRatePerDay(double RatePerDay) {
        this.RatePerDay = RatePerDay;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }
    
}

