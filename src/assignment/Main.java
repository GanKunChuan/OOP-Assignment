package assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static List<Bicycle> bicycles = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();
    private static List<Return> returns = new ArrayList<>();
    private static List<Voucher> vouchers = new ArrayList<>();
    
    private static int nextBikeNum = 26;
    
    public static void main(String[] args){
        // Default admin account
        Admin admin = new Admin("Admin", "admin@gocycle.com", "admin123");
        users.add(admin);
        
        // Initial bicycles
        bicycles.add(new Bicycle("B001","Folding Bike", "Brompton", "C Line Explore", "Black", 5.0, 30.0, 5));
        bicycles.add(new Bicycle("B002","Folding Bike", "Dahon", "Mariner D8", "Sliver", 4.0, 25.0, 5));
        bicycles.add(new Bicycle("B003","Folding Bike", "Tern", "Link D8", "Blue", 4.0, 20.0, 5));
        bicycles.add(new Bicycle("B004","Folding Bike", "Giant", "Expressway 2 City", "Grey", 3.0, 15.0, 5));
        bicycles.add(new Bicycle("B005","Folding Bike", "Montague", "UrbanLite", "Red", 3.0, 15.0, 5));
        bicycles.add(new Bicycle("B006","Mountain Bike", "Trek", "Marlin 7", "Grey", 5.0, 40.0, 4));
        bicycles.add(new Bicycle("B007","Mountain Bike", "Giant", "Talon 1", "Green", 4.0, 30.0, 4));
        bicycles.add(new Bicycle("B008","Mountain Bike", "Specialized", "Rockhopper Sport", "Blue", 5.0, 35.0, 4));
        bicycles.add(new Bicycle("B009","Mountain Bike", "Scott", "Aspect 940", "Grey", 4.0, 30.0, 4));
        bicycles.add(new Bicycle("B010","Mountain Bike", "Cannondale", "Trail 5", "Red", 4.0, 30.0, 4));
        bicycles.add(new Bicycle("B011","Road Bike", "Giant", "Contend AR 3", "Blue", 5.0, 40.0, 6));
        bicycles.add(new Bicycle("B012","Road Bike", "Specialized", "Allez", "White", 6.0, 50.0, 6));
        bicycles.add(new Bicycle("B013","Road Bike", "Trek", "Domane AL 2", "Purple", 3.0, 20.0, 6));
        bicycles.add(new Bicycle("B014","Road Bike", "Cannondale", "Aynapse Alloy 105", "Black", 7.0, 55.0, 6));
        bicycles.add(new Bicycle("B015","Road Bike", "Scott", "Speedster 10", "Red", 4.0, 30.0, 6));
        bicycles.add(new Bicycle("B016","Tandem Bike", "Cannondale", "Tandem 29", "Sliver", 10.0, 80.0, 2));
        bicycles.add(new Bicycle("B017","Tandem Bike", "Co-Motion", "Periscope", "Blue", 9.0, 75.0, 2));
        bicycles.add(new Bicycle("B018","Tandem Bike", "Giant", "Half-Wit Tandem", "White", 8.0, 70.0, 2));
        bicycles.add(new Bicycle("B019","Tandem Bike", "Burley", "Duet", "Yellow", 7.0, 60.0, 2));
        bicycles.add(new Bicycle("B020","Tandem Bike", "Schwinn", "Twinn Classic", "Green", 7.0, 55.0, 2));
        bicycles.add(new Bicycle("B021","Electric Bike", "Specialized", "Turbo Vado SL 4.0", "Black", 15.0, 50.0, 3));
        bicycles.add(new Bicycle("B022","Electric Bike", "Giant", "Quick E+", "Grey", 12.0, 45.0, 3));
        bicycles.add(new Bicycle("B023","Electric Bike", "Trek", "Verve+ 2", "Green", 12.0, 45.0, 3));
        bicycles.add(new Bicycle("B024","Electric Bike", "Rad Power", "RadCity 5 Plus", "White", 10.0, 40.0, 3));
        bicycles.add(new Bicycle("B025","Electric Bike", "Cannondale", "Tesoro Neo X", "Blue", 7.0, 35.0, 3));

        
        // Initial voucher
        vouchers.add(new Voucher("VCH5OFF", "RM5 OFF", 20, 5.0));
        vouchers.add(new Voucher("VCH10OFF", "RM10 OFF", 30, 10.0));
        vouchers.add(new Voucher("VCH20OFF", "RM20 OFF", 50, 20.0));
        vouchers.add(new Voucher("VCH25OFF", "RM25 OFF", 65, 25.0));
        
        int choice;
        String input;
        do{
            System.out.println("\n  _______   ______     ______ ____    ____  ______  __       _______ ");
            System.out.println(" /  _____| /  __  \\   /      |\\   \\  /   / /      ||  |     |   ____|");
            System.out.println("|  |  __  |  |  |  | |  ,----' \\   \\/   / |  ,----'|  |     |  |__   ");
            System.out.println("|  | |_ | |  |  |  | |  |       \\_    _/  |  |     |  |     |   __|  ");
            System.out.println("|  |__| | |  `--'  | |  `----.    |  |    |  `----.|  `----.|  |____ ");
            System.out.println(" \\______|  \\______/   \\______|    |__|     \\______||_______||_______|");
            System.out.println("======================================================================");
            System.out.println("                 WELCOME TO GOCYCLE BICYCLE RENTAL!!");
            System.out.println("======================================================================");
            System.out.println("1. Customer Login");
            System.out.println("2. Customer Register");
            System.out.println("3. Exit");
            
            // Input validation loop
            boolean isNumber;
            do{
                System.out.print("\nEnter Your Choice: ");
                input = sc.nextLine().trim();
                
                isNumber = true;
                if(input.isEmpty()){
                    isNumber = false;
                }else{
                    for (int i = 0; i < input.length(); i++){
                        if(!Character.isDigit(input.charAt(i))){
                            isNumber = false;
                            break;
                        }
                    }
                }
                
                if(isNumber == false){
                    System.out.println("Invalid input. Please enter again.");
                }
            }while(isNumber == false);
            
            choice = Integer.parseInt(input);
            
                switch(choice){
                case 1:
                    loginUser();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thank you for using GOCYCLE Rental System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try Again.");
            }
        }while(choice != 3);
        
    }

    private static void loginUser() {
        
        System.out.println("Login");
        String email;
        String password;
        boolean loggedIn = false;
        
        while (!loggedIn) {
        // Email validation loop
        while (true) {
            System.out.print("Enter Email: ");
            email = sc.nextLine().trim();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$")) {
                break;  //valid email
            } else{
                System.out.println("Invalid email format! Try again.\n");
            }
        }

        // Password validation loop
        while (true) {
            System.out.print("Enter Password (at least 6 characters, must include a digit): ");
            password = sc.nextLine().trim();

            if (password.length() >= 6 && password.matches(".*\\d.*")) {
                break; // valid password
            } else {
                System.out.println("Invalid password! Try again.\n");
            }
        }

        // Check credentials against users list
        User matchedUser = null;
        for (User u : users) {
            if (u.login(email, password)) {  
                matchedUser = u;
                break;
            }
        }

        if (matchedUser != null) {
            loggedIn = true;
            if (matchedUser.getRole().equals("customer")) {
                System.out.println("\nLogin Successful!");
                customerMenu((Customer) matchedUser);
            } else if (matchedUser.getRole().equals("admin")) {
                System.out.println("\nLogin Successful as Admin!");
                adminMenu((Admin) matchedUser);
            }
        } else {
            System.out.println("Login Failed. Invalid email or password.\n");
        }
    }
}

    private static void register() {
        System.out.println("Customer Registration");
        
        // name validation, only character and must > 4, loop to enter again
        String name;
        while (true) {
            System.out.print("Enter Name(Only letters and spaces allowed, min 4 characters): ");
            name = sc.nextLine().trim();
            if (name.matches("^[A-Za-z ]{4,}$")) {
                break;
            } else {
                System.out.println("Invalid name! Try again.\n");
            }
        }
        
        // email validation and a loop to enter again
        String email;
        while (true) {
            System.out.print("Enter Email: ");
            email = sc.nextLine().trim();

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$")) {
                System.out.println("Invalid email format! Try again.\n");
                continue;
            }
            
        // Check if email already exists
        boolean exists = false;
        for (User u : users) {
            if (u.email.equalsIgnoreCase(email)) {
                exists = true;
                break;
            }
        }
            if (exists) {
                System.out.println("Email already registered! Enter another one.\n");
            } else {
                break;
            }
        }
        
        // ic format validation and a loop to enter again
        String ic;
        while (true) {
            System.out.print("Enter Identity Card (e.g. XXXXXX-XX-XXXX): ");
            ic = sc.nextLine().trim();
            if (ic.matches("^\\d{6}-\\d{2}-\\d{4}$")) {
                break;
            } else {
                System.out.println("Invalid IC format! Try again.\n");
            }
        }
        
        // phone validation, 10-11digit start with 01, loop to enter again
        String phoneNo;
        while (true) {
            System.out.print("Enter Phone No(e.g. 0123456789): ");
            phoneNo = sc.nextLine().trim();
            if (phoneNo.matches("^01\\d{8,9}$")) {
                break;
            } else {
                System.out.println("Invalid phone number! Try again.\n");
            }
        }
        
        // validation only F & M , loop to enter agian
        char gender;
        while(true){
            System.out.print("Enter Gender (M/F): ");
            String g = sc.nextLine().trim().toUpperCase();
            if (g.equals("M") || g.equals("F")) {
                gender = g.charAt(0);
                break;
            } else {
                System.out.println("Invalid gender! Try again.\n");
            }
        }
        
        // password validation(at least 6 characters, must include digit) and a loop to enter again
        String password;
        while (true) {
            System.out.print("Enter Password(At least 6 characters and contain digit): ");
            password = sc.nextLine().trim();
            if (password.length() >= 6 && password.matches(".*\\d.*")) {
                break;
            } else {
                System.out.println("Invalid password! Try again.\n");
            }
        }
        
        Customer customer = new Customer(name, email, ic, phoneNo, gender, password);
        users.add(customer);
        customer.getActiveVouchers().add(new Voucher("VCH5OFF", "RM5 OFF", 20, 5.0));
        customer.getActiveVouchers().add(new Voucher("VCH10OFF", "RM10 OFF", 30, 10.0));
        customer.getActiveVouchers().add(new Voucher("VCH20OFF", "RM20 OFF", 50, 20.0));
        System.out.println("\nRegistration Successful! You can login now.");
        System.out.println("Returning to Login Page...");
    }
    
    // Menu
    private static void customerMenu(Customer customer) {
        String input2;
        int choice2;
        do{
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("       GOCYCLE Bicycle Rental");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("[1] Rent A Bicycle");
            System.out.println("[2] Return Bicycle");
            System.out.println("[3] View Rental History");
            System.out.println("[4] Reward");
            System.out.println("[5] Edit Profile");
            System.out.println("[6] LogOut");
            
            // Input validation loop
            boolean isNumber;
            do{
                System.out.print("\nEnter Your Choice: ");
                input2 = sc.nextLine().trim();
                
                isNumber = true;
                if(input2.isEmpty()){
                    isNumber = false;
                }else{
                    for (int i = 0; i < input2.length(); i++){
                        if(!Character.isDigit(input2.charAt(i))){
                            isNumber = false;
                            break;
                        }
                    }
                }
                
                if(isNumber == false){
                    System.out.println("Invalid input. Please enter again.");
                }
            }while(isNumber == false);
            
            choice2 = Integer.parseInt(input2);
            
            switch(choice2){
                case 1:
                    rentBicycle(customer);
                    break;
                case 2: 
                    returnBicycle(customer);
                    break;
                case 3: 
                    rentalHistory(customer);
                    break;
                case 4: 
                    reward(customer);
                    break;
                case 5:
                    editProfile(customer, sc, new ArrayList<>(users));
                    break;
                case 6: 
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid input. Please try agian.");
            }
        }while(choice2 != 6);
        
    }

    private static void adminMenu(Admin admin) {
        Report report = new Report();
        String input3;
        int choice3;
        do{
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
            System.out.println("     Admin Menu");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("[1] Manage Bicycles");
            System.out.println("[2] View Reports");
            System.out.println("[0] LogOut");
            
            // Input validation loop
            boolean isNumber;
            do{
                System.out.print("\nEnter Your Choice: ");
                input3 = sc.nextLine().trim();
                
                isNumber = true;
                if(input3.isEmpty()){
                    isNumber = false;
                }else{
                    for (int i = 0; i < input3.length(); i++){
                        if(!Character.isDigit(input3.charAt(i))){
                            isNumber = false;
                            break;
                        }
                    }
                }
                
                if(isNumber == false){
                    System.out.println("Invalid input. Please enter again.");
                }
            }while(isNumber == false);
            
            choice3 = Integer.parseInt(input3);
            
            switch(choice3){
                case 1: 
                    manageBicycles(admin);
                    break;
                case 2: 
                    viewReports(report, new ArrayList<>(bicycles), new ArrayList<>(returns));
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break; 
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }while (choice3 != 0);
    }

    // Customer features 
    private static void rentBicycle(Customer customer) {
        System.out.println("\n= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("                                          RENT BICYCLE");
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        // display available bicycle table
        System.out.println("\nAvailable Bicycles: ");
        List<String> available = new ArrayList<>();
        System.out.println("-------------------------------------------------------------------------------------------------");
        
        for(Bicycle b : bicycles){
            if (b.getQuantity() > 0){
                if(!available.contains(b.getType())){
                    available.add(b.getType());
                }
            }
        }
        
        if(available.isEmpty()){
                System.out.println("No bicycle available right now.");
                return;
            }
        
        for (String type : available){
                System.out.printf("%-7s%-88s |","|Type: ", type.toUpperCase());
                System.out.println("\n-------------------------------------------------------------------------------------------------");
                System.out.printf("|%-6s | %-12s | %-20s | %-10s | %-12s | %-12s | %-4s | %n",
                        "ID", "Brand", "Model", "Color", "Rate/Hr(RM)", "Rate/Day(RM)", "Qty");
                System.out.println("-------------------------------------------------------------------------------------------------");
                
                for (Bicycle b : bicycles){
                    if (b.getType().equals(type) && b.getQuantity() > 0){
                        System.out.printf("|%-6s | %-12s | %-20s | %-10s | %-12.2f | %-12.2f | %-4d | %n",
                                b.getBicycleID(), b.getBrand(), b.getModel(),b.getColor(), 
                                b.getRatePerHour(), b.getRatePerDay(), b.getQuantity());
                    }
                } 
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
        
        Bicycle selectedBicycle = null;
        // validation if user enter bicycle id that not available will loop
        do{ 
            System.out.print("\nEnter Bicycle ID to Rent: ");
            String BicycleID = sc.nextLine().trim().toUpperCase();
            
            selectedBicycle = null; 
            
            for(Bicycle b : bicycles){
                if(b.getBicycleID().equals(BicycleID) && b.getQuantity() > 0){
                    selectedBicycle = b;
                    break;
                }
            }
            if(selectedBicycle == null){
                System.out.println("Invalid selection or bicycle unavailable. Please try again.");
            }
        }while(selectedBicycle == null);
        
        String rt;
        String rentalType = "";
        do{
            System.out.println("\nSelect Rental Mode: [1]Hourly     [2]Daily");
            System.out.print("Enter [1] or [2]: ");
            rt = sc.nextLine().trim();
            if(rt.equals("1")){
                rentalType = "Hourly";
            }else if(rt.equals("2")){
                rentalType = "Daily";
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
            
        }while(!rt.equals("1") && !rt.equals("2"));
        
        String choiceST;
        LocalDateTime startTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        do{
            System.out.println("\nSelect Rental Start Time:");
            System.out.println("[1] Rent Now (ASAP)");
            System.out.println("[2] Schedule for Later");
            System.out.print("> ");
            choiceST = sc.nextLine().trim();
            
            if(choiceST.equals("1")){
                startTime = LocalDateTime.now();
                System.out.println("START TIME: " + startTime.format(formatter));
            }else if(choiceST.equals("2")){
                LocalDate date = null;
                LocalTime time = null;
                
                while (date == null){
                    try{
                        System.out.print("Enter Start Date(YYYY-MM-DD): ");
                        String d = sc.nextLine().trim();
                        date = LocalDate.parse(d); 
                        
                        if(date.isBefore(LocalDate.now())){
                            System.out.println("Date cannot be in the past. Please try again.\n");
                            date = null;
                        }
                        
                    }catch (Exception e){
                        System.out.println("Invalid date format. Please try again.\n");
                    }
                }
                
                while(time == null){
                    try{
                        System.out.print("Enter Start Time (HH:MM in 24hour format): ");
                        String t = sc.nextLine().trim();
                        time = LocalTime.parse(t);
                        
                        if(date.equals(LocalDate.now()) && time.isBefore(LocalTime.now())){
                            System.out.println("Time cannot be in the past for today. Please try again.\n");
                            time = null;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid time format. Please try again\n");
                    }
                }
                
                startTime = LocalDateTime.of(date, time);
                System.out.println("\nSTART TIME: " + startTime.format(formatter));
            }
            
            if(!choiceST.equals("1") && !choiceST.equals("2")){
                System.out.println("Invalid choice. Please try again.");
            }
        }while(!choiceST.equals("1") && !choiceST.equals("2"));
        
        System.out.println("\nRM30.00 deposit is required.");
        
        String confirm = "";
        do{
            System.out.print("\nConfirm Rental and pay deposit? (Y/N): ");
            confirm = sc.nextLine().trim().toUpperCase();
            
            if(confirm.equals("Y")){
                System.out.println("Process to payment...");
            }else if(confirm.equals("N")){
                System.out.println("\nBooking cancel. Return to Menu...");
                return;
            }else{
                System.out.println("Invalid input. Please enter Y or N.");
            }
            
        }while(!confirm.equals("Y") && !confirm.equals("N"));
        
        boolean paid = payment(30.00, "Rental Deposit");
        if(!paid){
            System.out.println("Deposit payment failed. Booking cancelled.");
            return;
        }
        
        Rental r = new Rental(rentalType, startTime, customer, selectedBicycle);
        rentals.add(r);
        
        // Reduce quantity of selected bicycle
        selectedBicycle.setQuantity(selectedBicycle.getQuantity() - 1);
        
        // Rental Confirmation
        System.out.println("--------------------------------------------------");
        System.out.println("                Rental Confirmation");
        System.out.println("--------------------------------------------------");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println(r);
        System.out.println("Deposot Paid : RM30.00 (PAID)");
        System.out.println("-------------------------------------------------");
        System.out.println("Remember to return the bicycle to get final payment.");
        System.out.print("\n~PRESS [ENTER] TO RETURN TO MAIN MENU~");
        sc.nextLine();
    }
    
    private static void returnBicycle(Customer customer) {
        List<Rental> activeRentals = new ArrayList<>();
        for(Rental r: rentals){
           if(r.isActive() && r.getCustomer().equals(customer)){
               activeRentals.add(r);
           }
        }
        
        if(activeRentals.isEmpty()){
            System.out.println("You have no any rentals to return.");
            System.out.print("\n~PRESS [ENTER] TO RETURN TO MAIN MENU~");
            sc.nextLine();
            return;
        }
        
        System.out.println("You have the following active rentals: ");
       
        int i = 1;
        for(Rental r: activeRentals){
            String rentalStr = r.toString();
            String[] lines = rentalStr.split("\n");
            System.out.println(i + ". " + lines[0]);
            for(int j = 1; j < lines.length; j++){
                System.out.println("   " + lines[j]);
            }
            System.out.println("   Deposit      : RM30.00\n");
            i++;
        }
        
        System.out.println("Select the rental bicycle you want to return...");
        
        Rental selected = null;
        do{
            System.out.print("Enter Rental ID: ");
            String id = sc.nextLine().trim().toUpperCase();
            for(Rental r : activeRentals){
                if(r.getRentalID().equals(id)){
                    selected = r;
                    break;
                }
            }
            if(selected == null){
                System.out.println("Invalid Rental ID. Please try again.\n");
            }
        }while(selected == null);
        
        String d;
        boolean hasDamage = false;
        do{
            System.out.print("Is the bicycle damaged? (Y/N): ");
            d = sc.nextLine().trim().toUpperCase();
            if(d.equals("Y")){
                hasDamage = true;
            }else if(d.equals("N")){
                hasDamage = false;
            }else{
                System.out.println("Invalid input. Please enter Y or N.\n");
            }
        }while(!d.equals("Y") && !d.equals("N"));
        
        String confirm;
        do{
            System.out.print("Confirm return and make payment? (Y/N): ");
            confirm = sc.nextLine().trim().toUpperCase();
            if(confirm.equals("Y")){
                System.out.println("\nReturning Bicycle...");
            }else if(confirm.equals("N")){
                System.out.println("Return cancelled. Returning to the main menu.\n");
                return;
            }else{
                System.out.println("Invalid input. Please enter Y or N.\n");
            }
        }while(!confirm.equals("Y") && !confirm.equals("N"));
        
        LocalDateTime returnTime = LocalDateTime.now();
        Return rt = new Return(selected,returnTime,hasDamage);
        returns.add(rt);
        
        //Show summary
        System.out.println("---------------RETURN---------------");
        System.out.println(selected.toString());
        System.out.println("Return Time  : " + returnTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Duration     : " + rt.getDuration());
        System.out.println("-------------------------------------");
        System.out.printf("Total Price       : RM%.2f%n", rt.getTotalPrice());
        System.out.printf("Damage Fee(if any): RM%.2f%n", rt.getDamageFee());
        System.out.printf("Service Fee(6%%)   : RM%.2f%n", rt.getServiceFee());
        
        // voucher
        double discount = 0.0;
        String use = "";
        double totalAmount = rt.getTotalPrice()  + rt.getDamageFee() + rt.getServiceFee();
        if(totalAmount > 30.00){
            do{
                if(!customer.getActiveVouchers().isEmpty()){
                    System.out.print("Use a voucher? (Y/N): ");
                    use = sc.nextLine().trim().toUpperCase();
                    if(use.equals("Y")){
                        System.out.println("\nYour Active Vouchers:");
                        for (Voucher v : customer.getActiveVouchers()) {
                            if(!v.isUsed())
                                System.out.printf("- %s (RM%.2f OFF)\n", v.getCode(), v.getDiscountAmount());
                        }
                        System.out.print("Enter voucher code: ");
                        String code = sc.nextLine().trim().toUpperCase();
                        Voucher v = customer.findActiveVoucher(code);
                        if (v != null) {
                            discount = v.getDiscountAmount();
                            rt.setDiscount(discount);
                            v.setUsed(true); 
                            System.out.println("Voucher applied!\n");
                        } else {
                            System.out.println("Voucher not found in your active vouchers. No discount applied.\n");
                        }
                    }else if(use.equals("N")){
                        System.out.println("Not discount applied.");
                    }else{
                        System.out.println("Invalid input. PLease enter Y or N.");
                    }
                }else{
                    break;
                }
            }while(!use.equals("Y") && !use.equals("N"));
            System.out.printf("Discount          : RM%.2f%n", discount);
        }
        System.out.printf("Total Amount      : RM%.2f%n", totalAmount);
        System.out.println("Deposit Paid      : RM30.00");
        System.out.println("-------------------------------------");
        if(rt.getFinalAmount() < 0){
            System.out.printf("Refund            : RM%.2f%n", Math.abs(rt.getFinalAmount()));
        }else{
            System.out.printf("Total Paid        : RM%.2f%n", rt.getFinalAmount());
        }
        System.out.println("-------------------------------------");
        
        // payment
        if(rt.getFinalAmount() > 0){
            boolean paid = payment(rt.getFinalAmount(), "Final Rental Fees");
            if(!paid){
                System.out.println("Payment failed. Return aborted.");
                return;
            }else{
                System.out.println("Payment Successful!");
            }
        }else if(rt.getFinalAmount() == 0){
            System.out.println("No additional payment required. Deposit covers all.");
        }else{
            double addFees = 30 - totalAmount;
            System.out.printf("\nAdditional RM%.2f is returned back to your TNG%n", addFees);
        } 
        selected.getBicycle().setDamaged(hasDamage);
        selected.setActive(false);
        int points = (int) Math.floor(rt.getFinalAmount() / 10);
        if(points < 0){
            points = 0;
        }else{
            customer.setRewardPoints(points);
        }
        
        // Generate Receipt
        System.out.println("---------------------------------------------");
        System.out.println("                  RECEIPT   ");
        System.out.println("---------------------------------------------");
        System.out.println("Rental ID  : " + selected.getRentalID());
        System.out.println("Bicycle    : " + selected.getBicycle().getType() + " " + selected.getBicycle().getBrand() +
                " " + selected.getBicycle().getModel() + " " + selected.getBicycle().getColor());
        System.out.println("Duration   : " + rt.getDuration() + " hours");
        if(rt.getFinalAmount() < 0){
            System.out.printf("Refund     : RM%.2f%n", Math.abs(rt.getFinalAmount()));
        }else{
            System.out.printf("Total Paid : RM%.2f%n", rt.getFinalAmount());
        }
        System.out.println("Earned Reward Points: " + points + " pts");
        
        System.out.print("\n~PRESS [ENTER] TO RETURN TO MAIN MENU~");
        sc.nextLine();
}

    private static boolean payment(double amount, String purpose) {
        System.out.println("\nPAYMENT FOR: " + purpose);
        System.out.printf("Amount to pay: RM%.2f%n", amount);
        System.out.println("\n------------------------------------");
        System.out.println("           Payment Method");
        System.out.println("------------------------------------");
        System.out.println("[1] Card");
        System.out.println("[2] Touch N Go");
        
        while(true){
            System.out.print("Select payment method: ");
            String input = sc.nextLine().trim();
            try{
                int choice = Integer.parseInt(input);
                
                if(choice == 1){
                    System.out.println("\nYou selected Card Payment.");
                    String cardNum;
                    do{
                        System.out.print("Enter Card Number: ");
                        cardNum = sc.nextLine().trim();
                        if(!cardNum.matches("\\d{16}")){
                            System.out.println("Invalid card number. Please try again.\n");
                        }
                    }while(!cardNum.matches("\\d{16}"));
                    
                    String cvv;
                    do{
                        System.out.print("Enter CVV Code: ");
                        cvv = sc.nextLine().trim(); 
                        if(!cvv.matches("\\d{3}")){
                            System.out.println("Invalid CVV. Please try again.\n");
                        }
                    }while(!cvv.matches("\\d{3}"));
                    
                    System.out.println("Card Payment Successful!\n");
                    return true;
                    
                }else if(choice == 2){
                    System.out.println("\nYou selected Touch N Go Payment.");
                    String phone;
                    do{
                        System.out.print("Enter Phone No: ");
                        phone = sc.nextLine().trim();
                        if(!phone.matches("01\\d{8,9}")){
                            System.out.println("Invalid phone number. Please try again.\n");
                        }
                    }while(!phone.matches("01\\d{8,9}"));
                    
                    String pin;
                    do{
                        System.out.print("Enter PIN number: ");
                        pin = sc.nextLine().trim();
                        if(!pin.matches("\\d{6}")){
                            System.out.println("Invalid PIN number. Please try again.\n");
                        }
                    }while(!pin.matches("\\d{6}"));
                    
                    System.out.println("Touch N Go payment successful!\n");
                    return true;
                    
                }else{
                    System.out.println("Invalid choice. Please enter 1 or 2.\n");
                }
            }catch (Exception e){
                System.out.println("Invalid input. Please enter a number.\n");
            }
        }
    }
    
    private static void rentalHistory(Customer customer) {
        System.out.println("\n==============================================");
        System.out.println("              Rental History");
        System.out.println("==============================================");
        System.out.println("Customer: " + customer.name);
        
        List<Rental> activeRentals = new ArrayList<>();
        List<Rental> completedRentals = new ArrayList<>();
        for(Rental r: rentals){
           if(r.isActive() && r.getCustomer().equals(customer)){
               activeRentals.add(r);
           }else if(!r.isActive() && r.getCustomer().equals(customer)){
               completedRentals.add(r);
           }
        }
        
        if(activeRentals.isEmpty() && completedRentals.isEmpty()){
            System.out.println("No rental history found");
            System.out.print("\n~PRESS [ENTER] TO RETURN TO MAIN MENU~");
            sc.nextLine();
            return;
        }
        
        //1. Display Current Active Rentals
        if(!activeRentals.isEmpty()){
            System.out.println("--------------------------------------------");
            System.out.println("Current Active Rentals: ");
            System.out.println("--------------------------------------------");
            int activeCount = 1;
            for(Rental r: activeRentals){
                String rentalStr = r.toString();
                String[] lines = rentalStr.split("\n");
                System.out.println(activeCount + ". " + lines[0]);
                for(int j = 1; j < lines.length; j++){
                    System.out.println("   " + lines[j]);
                }
                System.out.println("   Deposit      : RM30.00\n");
                activeCount++;
            }
        }else{
            System.out.println("No active rentals found.\n");
        }
        
        //2. Display Completed Rental History
        if(!completedRentals.isEmpty()){
            System.out.println("--------------------------------------------");
            System.out.println("Completed Rental: ");
            System.out.println("--------------------------------------------");
            int completedCount = 1;
            for(Rental r: completedRentals){
                Return rt = r.getReturns();
                    String rentalStr = r.toString();
                    String[] lines = rentalStr.split("\n");
                    System.out.println(completedCount + ". " + lines[0]);
                    for(int j = 1; j < lines.length; j++){
                        System.out.println("   " + lines[j]);
                    }
                    System.out.println("   Return Time  : " + rt.getReturnTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    if(r.getRentalType().equals("Hourly")){
                        System.out.println("   Duration     : " + rt.getDuration()+ " hours");
                    }else{
                        System.out.println("   Duration     : " + (int)rt.getDuration() + " day");
                    }
                    System.out.printf("   Total Price        : RM%.2f%n", rt.getTotalPrice());
                    System.out.printf("   Damage Fee(if any) : RM%.2f%n", rt.getDamageFee());
                    System.out.printf("   Service Fee(6%%)    : RM%.2f%n", rt.getServiceFee());
                    System.out.printf("   Discount           : RM%.2f%n", rt.getDiscount());
                    System.out.println("   Deposit Paid       : RM30.00");
                    if(r.getReturns().getFinalAmount() < 0){
                        System.out.printf("   Total Refund       : RM%.2f%n", Math.abs(rt.getFinalAmount()));
                        System.out.println("");
                    }else{
                        System.out.printf("   Total Paid         : RM%.2f%n", rt.getFinalAmount());
                        System.out.println("");
                    }
                    completedCount++;
            }
        }else{
            System.out.println("No completed rentals found.\n");
        }
    
        System.out.print("\n~PRESS [ENTER] TO RETURN TO MAIN MENU~");
        sc.nextLine();
    }
    
    public static void reward (Customer customer) {
        String input5;
        int choice5;
        do {
            System.out.println("\n==============================");
            System.out.println("     Reward & Voucher Menu    ");
            System.out.println("==============================");
            System.out.println("Reward Points: " + customer.getRewardPoints() + " pts");
            System.out.println("Earn 1 Point for every RM10 spent.");
            customer.showActiveVouchers();
            System.out.println("\n[1] Redeem New Voucher");
            System.out.println("[2] Back to Main Menu");

            // Input validation loop
            boolean isNumber;
            do{
               System.out.print("\nEnter Your Choice: ");
               input5 = sc.nextLine().trim();

               isNumber = true;
               if(input5.isEmpty()){
                   isNumber = false;
               }else{
                    for (int i = 0; i < input5.length(); i++){
                        if(!Character.isDigit(input5.charAt(i))){
                            isNumber = false;
                            break;
                        }
                    }
               }
                if(isNumber == false){
                    System.out.println("Invalid choice! Please choose [1] or [2].\n");
                }
            }while(isNumber == false);

            choice5 = Integer.parseInt(input5);

            switch (choice5) {
                case 1: {
                    customer.showAvailableVouchers(vouchers);
                    System.out.print("\nEnter voucher to redeem (1-" + vouchers.size() + ") OR [B] to go back: ");
                    String input = sc.nextLine().trim();
                    if (input.equalsIgnoreCase("B")) 
                        break;
                    int opt;
                    try {  //make sure for valid int input
                        opt = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid option! Try Again.\n");
                        continue;
                    } 

                    System.out.print("Confirm redeem? (Y/N): ");
                    String conf = sc.nextLine().trim();
                    if (conf.equals("Y")) {
                        customer.redeemVoucher(opt, vouchers);
                    } else if (conf.equals("N")){
                        System.out.println("Redemption cancelled.\n");
                    }
                    else {
                        System.out.println("Invalid! Enter Y or N.\n");
                    } 
                }
                case 2: 
                   System.out.println("Exiting reward redeem...");
                   return;  //back to menu

                default:
                    System.out.println("Invalid choice! Please choose [1] or [2].\n");
            }
        } while(choice5 != 2);
    }  

    public static void editProfile(Customer customer, Scanner sc, ArrayList<User> users) {
        String input4;
        int choice4;
        do{
        System.out.println("= = = = = = = = = = = = = = = = = = =");
        System.out.println("            Edit Profile");
        System.out.println("= = = = = = = = = = = = = = = = = = =\n");
        System.out.println("Name     : " + customer.getName());
        System.out.println("IC       : " + customer.getIC());
        System.out.println("Email    : " + customer.getEmail());
        System.out.println("Phone No : " + customer.getPhoneNo());
        System.out.println("Gender   : " + customer.getGender());
        System.out.println("Password : ******");  // hide actual password
        System.out.println("----------------------------------------");
        System.out.println("Enter choice [1-6] to edit or [7] to exit.");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit IC Number");
        System.out.println("3. Edit Email");
        System.out.println("4. Edit Phone Number");
        System.out.println("5. Edit Gender");
        System.out.println("6. Edit Password");
        System.out.println("7. Exit");
       
        // Input validation loop
        boolean isNumber;
            do{
               System.out.print("\nEnter Your Choice: ");
               input4 = sc.nextLine().trim();
                
               isNumber = true;
               if(input4.isEmpty()){
                   isNumber = false;
               }else{
                    for (int i = 0; i < input4.length(); i++){
                        if(!Character.isDigit(input4.charAt(i))){
                            isNumber = false;
                            break;
                        }
                    }
               }
                if(isNumber == false){
                    System.out.println("Invalid choice. Please enter again.\n");
                }
            }while(isNumber == false);
            
            choice4 = Integer.parseInt(input4);

            switch (choice4) {
                case 1: // Name
                    while (true) {
                        System.out.print("Enter new name (Only letters and spaces allowed, min 4 characters): ");
                        String newName = sc.nextLine().trim();
                        if (newName.equalsIgnoreCase(customer.getName())){
                            System.out.println("Already registered name! Try Again.\n");
                            continue;
                        }
                        if (newName.matches("^[A-Za-z ]{4,}$")) {
                            customer.setName(newName);
                            System.out.println("Name updated successfully!");
                            break;
                        } else {
                            System.out.println("Invalid name! Try Again!\n");
                        }
                    }
                    break;

                case 2: // IC Number
                    while (true) {
                        System.out.print("Enter new IC (e.g. XXXXXX-XX-XXXX): ");
                        String newIC = sc.nextLine().trim();
                        if (newIC.equalsIgnoreCase(customer.getIC())){
                            System.out.println("Already registered IC! Try Again.\n");
                            continue;
                        }
                        if (newIC.matches("^\\d{6}-\\d{2}-\\d{4}$")) {
                            customer.setIC(newIC);
                            System.out.println("IC updated successfully!");
                            break;
                        } else {
                            System.out.println("Invalid IC! Try Again.\n");
                        }
                    }
                    break;

                case 3: // Email
                    while (true) {
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine().trim();
                        if (!newEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$")) { 
                            System.out.println("Invalid email format! Try Again.\n");
                            continue;
                        }
                        boolean exists = false;
                        for (User u : users) {
                            if (u != customer && u.email.equalsIgnoreCase(newEmail)) {
                                exists = true;
                                break;
                            }
                        }
                        if (exists) {
                            System.out.println("Email already in use! Try another.\n");
                        } else {
                            customer.setEmail(newEmail);
                            System.out.println("Email updated successfully!");
                            break;
                        }
                    }
                    break;

                case 4: // PhoneNo
                    while (true) {
                        System.out.print("Enter new phone number (e.g. 0123456789): ");
                        String newPhoneNo = sc.nextLine().trim();
                        if (newPhoneNo.equalsIgnoreCase(customer.getPhoneNo())){
                            System.out.println("Already registered Phone No! Try Again.\n");
                            continue;
                        }
                        if (newPhoneNo.matches("^01\\d{8,9}$")) {
                            customer.setPhoneNo(newPhoneNo);
                            System.out.println("Phone updated successfully!");
                            break;
                        } else {
                            System.out.println("Invalid phone! Try Again.\n");
                        }
                    }
                    break;

                case 5: // Gender
                    while (true) {
                        System.out.print("Enter gender (M/F): ");
                        String newGender = sc.nextLine().trim();
                        if (newGender.equals("M") || newGender.equals("F")) {
                            customer.setGender(newGender.charAt(0));
                            System.out.println("Gender updated successfully!");
                            break;
                        } else {
                            System.out.println("Invalid! Enter M or F.\n");
                        }
                    }
                    break;

                case 6: // Password
                    while (true) {
                        System.out.print("Enter current password: ");
                        String current = sc.nextLine();
                        if (!current.equals(customer.getPassword())) {
                            System.out.println("Wrong current password! Try Again.\n");
                        } else {
                            String oldPassword = current;
                            while (true) {
                                System.out.print("Enter new password (At least 6 characters and contain digit): ");
                                String newPass = sc.nextLine();
                                if (newPass.equals(oldPassword)) {
                                    System.out.println("New password cannot be the same as the current password! Try again.\n");
                                    continue;
                                }
                                if (newPass.length() < 6 || !newPass.matches(".*\\d.*")) {
                                    System.out.println("Invalid password format! Try Again.\n");
                                    continue;
                                }
                                System.out.print("Confirm new password: ");
                                String confirm = sc.nextLine();
                                if (!confirm.equals(newPass)) {
                                    System.out.println("Passwords do not match! Try again.\n");
                                } else {
                                    customer.setPassword(confirm);
                                    System.out.println("Password updated successfully!");
                                    break;
                                }
                            } break;
                        }
                    } break;

                case 7:
                    System.out.println("Exiting profile edit...");
                    return; // exit method

                default:
                    System.out.println("Invalid choice! Please Try Again.\n");

            }
        }while(choice4 != 7);
    }
    
    // Admin features
    private static void manageBicycles(Admin admin) {
        String input;
        int choice;
        do {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("      Manage Bicycles");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("[1] View All Bicycles");
            System.out.println("[2] Add New Bicycle");
            System.out.println("[3] Update Bicycle Details");
            System.out.println("[4] Delete Bicycle");
            System.out.println("[5] Repair Bicycle");
            System.out.println("[0] Back to Admin Menu");

            boolean isNumber;
            do {
                System.out.print("\nEnter Your Choice: ");
                input = sc.nextLine().trim();
                isNumber = !input.isEmpty() && input.chars().allMatch(Character::isDigit);
                if (!isNumber) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } while (!isNumber);
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    viewAllBicycles();
                    break;
                case 2:
                    addBicycle();
                    break;
                case 3:
                    updateBicycle();
                    break;
                case 4:
                    deleteBicycle();
                    break;
                case 5:
                    repairBicycle();
                    break;  
                case 0:
                    System.out.println("Returning to Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void viewAllBicycles() {
        System.out.println("\n--- Current Bicycle Status ---");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-15s | %-12s | %-20s | %-10s | %-12s | %-12s | %-4s | %-15s |%n",
                "ID", "Type", "Brand", "Model", "Color", "Rate/Hr(RM)", "Rate/Day(RM)", "Qty", "Under Maintenance");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Bicycle b : bicycles) {
            System.out.printf("| %-6s | %-15s | %-12s | %-20s | %-10s | %-12.2f | %-12.2f | %-4d | %-15d |%n",
                    b.getBicycleID(), b.getType(), b.getBrand(), b.getModel(), b.getColor(),
                    b.getRatePerHour(), b.getRatePerDay(), b.getQuantity(), b.getUnderMaintenanceCount());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\n~PRESS [ENTER] TO RETURN TO THE MAIN MENU~");
        sc.nextLine();
    }

    private static void addBicycle() {
        System.out.println("\n--------------------------");
        System.out.println("    + Add New Bicycle");
        System.out.println("--------------------------");
        // Get Bicycle Type
        System.out.println("Select Bicycle Type:");
        System.out.println("1. Folding Bike\n2. Mountain Bike\n3. Road Bike\n4. Tandem Bike\n5. Electric Bike");
        String type = "";
        while(type.isEmpty()) {
            System.out.print("> ");
            String choice = sc.nextLine().trim();
            switch(choice) {
                case "1": type = "Folding Bike"; break;
                case "2": type = "Mountain Bike"; break;
                case "3": type = "Road Bike"; break;
                case "4": type = "Tandem Bike"; break;
                case "5": type = "Electric Bike"; break;
                default: System.out.println("Invalid type. Please enter a number from 1-5.");
            }
        }

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine().trim();
        System.out.print("Enter Model: ");
        String model = sc.nextLine().trim();
        System.out.print("Enter Color: ");
        String color = sc.nextLine().trim();

        double ratePerHour = -1, ratePerDay = -1;
        int quantity = -1;

        // Input validation for numbers
        while (ratePerHour < 0) {
            try {
                System.out.print("Enter Rate Per Hour (RM): ");
                ratePerHour = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        while (ratePerDay < 0) {
            try {
                System.out.print("Enter Rate Per Day (RM): ");
                ratePerDay = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        while (quantity < 0) {
            try {
                System.out.print("Enter Quantity Available: ");
                quantity = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        // Generate new Bicycle ID
        String newId = String.format("B%03d", nextBikeNum++);
        Bicycle newBicycle = new Bicycle(newId, type, brand, model, color, ratePerHour, ratePerDay, quantity);
        bicycles.add(newBicycle);

        System.out.println("\nBicycle " + newId + " added successfully!");
        System.out.print("\n~PRESS [ENTER] TO RETURN TO THE MAIN MENU~");
        sc.nextLine();
    }

    private static void updateBicycle() {
        System.out.println("\n--------------------------");
        System.out.println("     Update Bicycle");
        System.out.println("--------------------------");
        System.out.print("Enter Bicycle ID to update: ");
        String id = sc.nextLine().trim().toUpperCase();

        Bicycle toUpdate = null;
        for (Bicycle b : bicycles) {
            if (b.getBicycleID().equals(id)) {
                toUpdate = b;
                break;
            }
        }

        if (toUpdate == null) {
            System.out.println("Bicycle ID not found.");
            return;
        }

        System.out.println("\nUpdating details for " + toUpdate.getBrand() + " " + toUpdate.getModel() + " (" + id + ")");
        System.out.println("Leave blank to keep current value.");

        try {
            System.out.print("Enter new Rate Per Hour (Current: " + toUpdate.getRatePerHour() + "): ");
            String newRateHr = sc.nextLine().trim();
            if (!newRateHr.isEmpty()) {
                toUpdate.setRatePerHour(Double.parseDouble(newRateHr));
            }

            System.out.print("Enter new Rate Per Day (Current: " + toUpdate.getRatePerDay() + "): ");
            String newRateDay = sc.nextLine().trim();
            if (!newRateDay.isEmpty()) {
                toUpdate.setRatePerDay(Double.parseDouble(newRateDay));
            }

            System.out.print("Enter new Quantity (Current: " + toUpdate.getQuantity() + "): ");
            String newQty = sc.nextLine().trim();
            if (!newQty.isEmpty()) {
                toUpdate.setQuantity(Integer.parseInt(newQty));
            }
            System.out.println("\nBicycle details updated successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Update failed.");
        }
        System.out.print("\n~PRESS [ENTER] TO RETURN TO THE MAIN MENU~");
        sc.nextLine();
    }

    private static void deleteBicycle() {
        System.out.println("\n--------------------------");
        System.out.println("    - Delete Bicycle");
        System.out.println("--------------------------");
        System.out.print("Enter Bicycle ID to delete: ");
        String id = sc.nextLine().trim().toUpperCase();

        Bicycle toDelete = null;
        for (Bicycle b : bicycles) {
            if (b.getBicycleID().equals(id)) {
                toDelete = b;
                break;
            }
        }

        if (toDelete == null) {
            System.out.println("Bicycle ID not found.");
            return;
        }

        System.out.print("Are you sure you want to delete " + toDelete.getBrand() + " " + toDelete.getModel() + "? (Y/N): ");
        String confirm = sc.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            bicycles.remove(toDelete);
            System.out.println("Bicycle deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
        System.out.print("\n~PRESS [ENTER] TO RETURN TO THE MAIN MENU~");
        sc.nextLine();
    }
    
    private static void repairBicycle() {
        System.out.println("\n----------------------------");
        System.out.println("       Repair Bicycle");
        System.out.println("----------------------------");
        boolean foundMaintenance = false;
        for(Bicycle b : bicycles){
            if(b.getUnderMaintenanceCount() > 0){
                foundMaintenance = true;
                System.out.printf("%s - %s %s (%s) \nUnder Maintenance: %d%n",
                b.getBicycleID(), b.getBrand(), b.getModel(), b.getColor(), b.getUnderMaintenanceCount());
            }
        }
        
        if(!foundMaintenance){
            System.out.println("No bicycle currently under maintenance.");
            System.out.print("\n~PRESS [ENTER] TO RETURN TO THE MAIN MENU~");
            sc.nextLine();
            return;
        }
        
        Bicycle repairBicycle = null;
        do{
            System.out.print("\nEnter Bicycle ID to repair: ");
            String repairID = sc.nextLine().trim().toUpperCase();
            
            for(Bicycle b : bicycles){
                if(b.getBicycleID().equals(repairID)){
                    if(b.getUnderMaintenanceCount() > 0){
                        repairBicycle = b;
                        break;
                    }
                }
            }
            
            if(repairBicycle == null){
                System.out.println("Invalid Bicycle ID. Please try again.");
            }
            
        }while(repairBicycle == null);
        
        String confirm = "";
        do{
            System.out.print("Confirm to repair? (Y/N): ");
            confirm = sc.nextLine().trim().toUpperCase();
            
            if(confirm.equals("Y")){
                repairBicycle.repair();
                System.out.println("\n1 unit of " + repairBicycle.getBrand() + " " 
                + repairBicycle.getModel() + " has been repaired and returned to available stock.");
            }else if(confirm.equals("N")){
                System.out.println("Returning to Admin Menu...");
                return;
            }else{
                System.out.println("Invalid input. Please enter Y or N.\n");
            }
            
        }while(!confirm.equals("Y") && !confirm.equals("N"));
  
    }

    
    public static void viewReports(Report report, List<Bicycle> bicycles, List<Return> returns){
        System.out.println("\n=== REPORTS MENU ===");
        System.out.println("[1] Sales Report");
        System.out.println("[2] Bicycle Rental Report (All Time)");
        System.out.println("[3] Back to Main Menu");
        System.out.print("Enter choice: ");
        String choice6 = sc.nextLine().trim();

        switch(choice6) {
            case "1":
                while (true) {
                    System.out.print("Enter Report Period (MM-YYYY): ");
                    String period = sc.nextLine().trim();

                    // Validate format: MM-YYYY
                    if (!period.matches("^(0[1-9]|1[0-2])-(19\\d{2}|20(0\\d|1\\d|2[0-5]))$")) {
                        System.out.println("Invalid format! Please use MM-YYYY (e.g., 08-2025)\n");
                        continue;
                    }

                    // Validate existence in returns
                    boolean exists = false;
                    for (Return rt : returns) {
                        String month = String.format("%02d", rt.getReturnTime().getMonthValue());
                        String year  = String.valueOf(rt.getReturnTime().getYear());
                        String rtPeriod = month + "-" + year;
                        if (rtPeriod.equals(period)) {
                            exists = true;
                            break;
                        }
                    } 

                    if (!exists) {
                        System.out.println("No records found for " + period + ". Please try again.\n");
                        break;
                    }

                    // If format valid and data exists show report
                    report.generateSalesReport(returns, period);
                    break;
                }
                break;
            case "2":
                report.generateUsageReportAll(bicycles, returns);
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid choice. Try Again.\n");
        }
    }
}



