package assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
    
    private String period;  
    
     public String getPeriod() {
        return period;
    }
     
    public void setPeriod(String period) {
        this.period = period;
    }

    private String formatPeriod(String period) {
        String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        String[] names  = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String mm = period.substring(0,2), yyyy = period.substring(3);
        String name = mm;
        for (int i = 0; i < months.length; i++) if (months[i].equals(mm)) { name = names[i]; break; }
        return name + " " + yyyy;
    }

   public void generateSalesReport(List<Return> returns, String period) {
       
       System.out.println("\n------------------------- SALES REPORT -------------------------");
       System.out.println("Report Period : " + formatPeriod(period));
       System.out.println("----------------------------------------------------------------");
       System.out.printf("%-15s | %-8s | %-12s | %-14s%n",  
                      "Bicycle Type", "Rentals", "Revenue (RM)", "Damage Charges (RM)");
       System.out.println("----------------------------------------------------------------");
       
          if (returns.isEmpty()) {
            System.out.println("No completed rentals in the system.");
            return;
          }
          
       // Store totals grouped by bicycle type
       Map<String, Integer> rentalCounts = new HashMap<>();
       Map<String, Double> revenueTotals = new HashMap<>();
       Map<String, Double> damageTotals  = new HashMap<>();

       for (Return rt : returns) {
           // Filter by selected month-year
           String month = String.format("%02d", rt.getReturnTime().getMonthValue());
           String year  = String.valueOf(rt.getReturnTime().getYear());
           String rtPeriod = month + "-" + year;

           if (rtPeriod.equals(period)) {
               String type = rt.getRental().getBicycle().getType();
               double revenue = rt.getTotalPrice() + rt.getServiceFee() - rt.getDiscount();
               double damage  = rt.getDamageFee();

               rentalCounts.put(type, rentalCounts.getOrDefault(type, 0) + 1);
               revenueTotals.put(type, revenueTotals.getOrDefault(type, 0.0) + revenue);
               damageTotals.put(type, damageTotals.getOrDefault(type, 0.0) + damage);
           }
       }

       // Print report per bicycle type
       double grandRevenue = 0, grandDamage = 0;
       int totalRentals = 0;

       for (String type : rentalCounts.keySet()) {
           int rentals = rentalCounts.get(type);
           double revenue = revenueTotals.get(type);
           double damage  = damageTotals.get(type);

           System.out.printf("%-15s | %-8d | %-12.2f | %-14.2f%n", 
                             type, rentals, revenue, damage);

           totalRentals += rentals;
           grandRevenue += revenue;
           grandDamage  += damage;
       }

       System.out.println("----------------------------------------------------------------");
       System.out.printf("%-15s | %-8d | %-12.2f | %-14.2f%n",  
                         "TOTAL", totalRentals, grandRevenue, grandDamage);
       System.out.println("----------------------------------------------------------------");
    
       // Determine most rented & highest revenue types
       String mostRentedType = "-";
       String highestRevType = "-";
       int maxRentals = -1;
       double maxRevenue = -1.0;

       for (String type : rentalCounts.keySet()) {
           int count = rentalCounts.get(type);
           double revenue = revenueTotals.getOrDefault(type, 0.0);
           if (count > maxRentals) {
               maxRentals = count;
               mostRentedType = type;
           }
           if (revenue > maxRevenue) {
               maxRevenue = revenue;
               highestRevType = type;
           }
       }

       // Print summary
       System.out.println("\nMost Rented Bicycle Type   : " + mostRentedType);
       System.out.println("Highest Revenue Type       : " + highestRevType);
       System.out.println("----------------------------------------------------------------");

   }

    //Bicycle Usage Report
    public void generateUsageReportAll(List<Bicycle> bicycles, List<Return> returns) {
        System.out.println("\n----------------------------------- BICYCLE RENTAL REPORT (ALL TIME) -----------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");   
        
        if (bicycles.isEmpty() || returns.isEmpty()) {
            System.out.println("No completed rentals in the system.");
            return;
        }

        // Count usage per bicycle
        Map<String, Integer> usageCount = new HashMap<>();
        Map<String, Double> totalHours = new HashMap<>();
        
        for (Return rt : returns) {
            String bikeID = rt.getRental().getBicycle().getBicycleID();
            double hours = rt.getDuration();
            usageCount.put(bikeID, usageCount.getOrDefault(bikeID, 0) + 1);
            totalHours.put(bikeID, totalHours.getOrDefault(bikeID, 0.0) + hours);
        }

        System.out.printf("%-6s | %-13s | %-20s | %-12s | %-17s | %-18s%n",
                "ID", "Type", "Model", "Times Rented", "Total Rented (hrs)", "Avg Duration (hrs)");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for (Bicycle b : bicycles) {
            int count = usageCount.getOrDefault(b.getBicycleID(), 0);
            double total = totalHours.getOrDefault(b.getBicycleID(), 0.0);
            double avg   = (count > 0 ? total / count : 0.0);
            System.out.printf("%-6s | %-13s | %-20s | %-12d | %-17.2f | %-18.2f%n",
                b.getBicycleID(), b.getType(), b.getModel(), count, total, avg);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
        
        //Totals section
        int grandTimes = 0;
        double grandHours = 0.0;
        int mostRentedIdx = -1;
        int maxCount = -1;

        for (int i = 0; i < bicycles.size(); i++) {
            Bicycle b = bicycles.get(i);
            int count = usageCount.getOrDefault(b.getBicycleID(), 0);
            double total = totalHours.getOrDefault(b.getBicycleID(), 0.0);

            grandTimes += count;
            grandHours += total;
            
            if (count > maxCount) {
                maxCount = count;
                mostRentedIdx = i;
            }
        }

        double avgPerRental = (grandTimes > 0 ? grandHours / grandTimes : 0.0);

        //Find the most rented bicycle
        String mostRentedInfo = "-";
        if (mostRentedIdx >= 0) {
            Bicycle mostB = bicycles.get(mostRentedIdx);
            mostRentedInfo = mostB.getBicycleID() + " (" + mostB.getType() + " " + mostB.getModel() + ")";
        }


        //Print summary
        System.out.println("\nTOTAL Rentals            : " + grandTimes);
        System.out.printf ("TOTAL Hours              : %.2f%n", grandHours);
        System.out.printf ("TOTAL Average Hours/Rent : %.2f%n", avgPerRental);
        System.out.println("Most Rented Bicycle      : " + mostRentedInfo);
        System.out.println("-------------------------------------------------------------------------------------------------------");

    }
}

