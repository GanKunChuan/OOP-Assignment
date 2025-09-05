package assignment;

import java.time.Duration;
import java.time.LocalDateTime;

public class Return {
    private Rental rental;
    private LocalDateTime returnTime;
    private double duration;
    private double totalPrice;
    private double damageFee;
    private double serviceFee;
    private double discount;
    private double finalAmount;
    private boolean hasDamage;
    

    public Return(Rental rental, LocalDateTime returnTime, boolean hasDamage) {
        this.rental = rental;
        this.returnTime = returnTime;
        this.hasDamage = hasDamage;
        calculateDuration();
        calculateFees();
    }
    
    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public double getDuration() {
        return duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDamageFee() {
        return damageFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getDiscount(){
        return discount;
    }
    
    public double getFinalAmount() {
        return finalAmount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        calculateFees(); 
    }
    
    public void setFinalAmount(double finalAmount){
        this.finalAmount = finalAmount;
    }
    
    private void calculateDuration(){
        long d = Duration.between(rental.getStartTime(),returnTime).toMinutes();
        this.duration = Math.ceil(d/60.0);
    }
    
    private void calculateFees(){
        if(rental.getRentalType().equals("Hourly")){
            totalPrice = rental.getBicycle().getRatePerHour() * duration;
        }else{
            totalPrice = rental.getBicycle().getRatePerDay() * Math.ceil(duration / 24.0);
        }
        
        if(hasDamage == true){
            damageFee = 50.00;
        }else{
            damageFee = 0.00;
        }
        
        serviceFee = totalPrice * 0.06;
        
        finalAmount = totalPrice + damageFee + serviceFee - Rental.getDeposit() - discount;
    }

}

