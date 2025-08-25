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
    
    private static int nextBikeNum = 4;
    private static int nextRentalNum = 1;
    
    public static void main(String[] args){
        // Default admin account
        Admin admin = new Admin("Admin", "admin@gocycle.com", "admin123");
        users.add(admin);
        
        // Initial bicycles
        bicycles.add(new Bicycle("B001","Folding Bike", "Brompton", "C Line Explore", "Black", 3.0, 15.0, 5, false));
        bicycles.add(new Bicycle("B002","Folding Bike", "Dahon", "Mariner D8", "Sliver", 3.0, 15.0, 5, false));
        bicycles.add(new Bicycle("B003","Folding Bike", "Tern", "Link D8", "Blue", 3.0, 15.0, 5, false));
        bicycles.add(new Bicycle("B004","Folding Bike", "Giant", "Expressway 2 City", "Grey", 3.0, 15.0, 5, false));
        bicycles.add(new Bicycle("B005","Folding Bike", "Montague", "UrbanLite", "Red", 3.0, 15.0, 5, false));
        bicycles.add(new Bicycle("B006","Mountain Bike", "Trek", "Marlin 7", "Grey", 3.0, 25.0, 3, false));
        bicycles.add(new Bicycle("B007","Mountain Bike", "Giant", "Talon 1", "Green", 3.0, 25.0, 3, false));
        bicycles.add(new Bicycle("B008","Mountain Bike", "Specialized", "Rockhopper Sport", "Blue", 3.0, 25.0, 3, false));
        bicycles.add(new Bicycle("B009","Mountain Bike", "Scott", "Aspect 940", "Grey", 3.0, 25.0, 3, false));
        bicycles.add(new Bicycle("B010","Mountain Bike", "Cannondale", "Trail 5", "Red", 3.0, 25.0, 3, false));
        bicycles.add(new Bicycle("B011","Road Bike", "Giant", "Contend AR 3", "Blue", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B012","Road Bike", "Specialized", "Allez", "White", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B013","Road Bike", "Trek", "Domane AL 2", "Purple", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B014","Road Bike", "Cannondale", "Aynapse Alloy 105", "Black", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B015","Road Bike", "Scott", "Speedster 10", "Red", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B016","Tandem Bike", "Cannondale", "Tandem 29", "Sliver", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B017","Tandem Bike", "Co-Motion", "Periscope", "Blue", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B018","Tandem Bike", "Giant", "Half-Wit Tandem", "White", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B019","Tandem Bike", "Burley", "Duet", "Yellow", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B020","Tandem Bike", "Schwinn", "Twinn Classic", "Green", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B021","Electric Bike", "Specialized", "Turbo Vado SL 4.0", "Black", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B022","Electric Bike", "Giant", "Quick E+", "Grey", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B023","Electric Bike", "Trek", "Verve+ 2", "Green", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B024","Electric Bike", "Rad Power", "RadCity 5 Plus", "White", 7.0, 35.0, 2, false));
        bicycles.add(new Bicycle("B025","Electric Bike", "Cannondale", "Tesoro Neo X", "Blue", 7.0, 35.0, 2, false));
        
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
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Customer Register");
            System.out.println("4. Exit");
            
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
                    loginUser();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    System.out.println("Thank you for using GOCYCLE Rental System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try Again.");
            }
        }while(choice != 4);
    }

    private static void loginUser() {
        System.out.println("Login");
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        boolean found = false;
        
        for(User u : users){
            if(u.login(email, password)){
                found = true;
                if(u.getRole().equals("customer")){
                    System.out.println("\nLogin Successful!");
                    customerMenu((Customer)u);
                }else if(u.getRole().equals("admin")){
                    System.out.println("\nLogin Successful as Admin!");
                    adminMenu((Admin)u);
                }
                break;
            }
        }
        
        if(found == false)
            System.out.println("Login Failed. Invalid email or password.");
    }

    private static void register() {
        System.out.println("Customer Registration");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        // name validation, only character and must > 4, loop to enter again
        
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        // email validation and a loop to enter again
        // Check if email already exists
        for (User u: users){
            if(u.email.equals(email)){
                System.out.println("Email already registered.");
            }
        }
        
        System.out.print("Enter Identitty Card: ");
        String ic = sc.nextLine();
        // ic format validation and a loop to enter again
        
        System.out.print("Enter PhoneNo: ");
        String phoneNo = sc.nextLine();
        // phone validation, 10-11digit start with 01, loop to enter again
        
        char gender;
        do{
            System.out.print("Enter Gender(M/F): ");
            String g = sc.nextLine().toUpperCase();
            if(g.length() == 1){
                gender = g.charAt(0);
            }else{
                gender = 'X';
            }
        }while (gender != 'M' && gender != 'F');
        // validation only F & M , loop to enter agian
        
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        // password validation and a loop to enter again
        
        users.add(new Customer(name, email, ic, phoneNo, gender, password));
        System.out.println("\nRegistration Successful! You can login now.");
        System.out.println("Returning to Login Page...");
    }
    
    // Menu
    private static void customerMenu(Customer customer) {
        String input2;
        int choice2;
        do{
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("    GOCYCLE Bicycle Rental");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("[1] Rent A Bicycle");
            System.out.println("[2] Return Bicycle");
            System.out.println("[3] View Rental History");
            System.out.println("[4] Reward");
            System.out.println("[5] Edit Profile");
            System.out.println("[0] LogOut");
            
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
                    // view rental history()
                    break;
                case 4: 
                    // reward()
                    break;
                case 5:
                    // edit profile()
                    break;
                case 0: 
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid input. Please try agian.");
            }
        }while(choice2 != 0);
        
    }

    private static void adminMenu(Admin admin) {
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
                    // manageBicycles()
                    break;
                case 2: 
                    // viewReports()
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
            if (b.getQuantity() > 0 && !b.isUnderMaintenance()){
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
                    if (b.getType().equals(type) && b.getQuantity() > 0 && !b.isUnderMaintenance()){
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
                if(b.getBicycleID().equals(BicycleID) && b.getQuantity() > 0 && !b.isUnderMaintenance()){
                    selectedBicycle = b;
                    break;
                }
            }
            if(selectedBicycle == null){
                System.out.println("Invalid selection or bicycle unavailable. Please try again.");
            }
        }while(selectedBicycle == null);
        
        String rt;
        String rentalType;
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
                System.out.println("\nSTART TIME: " + startTime.format(formatter));
            }else if(choiceST.equals("2")){
                LocalDate date = null;
                LocalTime time = null;
                
                while (date == null){
                    try{
                        System.out.print("Enter Start Date(YYYY-MM-DD): ");
                        String d = sc.nextLine().trim();
                        date = LocalDate.parse(d); 
                    }catch (Exception e){
                        System.out.println("Invalid date format. Please try again.");
                    }
                }
                
                while(time == null){
                    try{
                        System.out.print("Enter Start Time (HH:MM in 24hour format): ");
                        String t = sc.nextLine().trim();
                        time = LocalTime.parse(t);
                    }catch(Exception e){
                        System.out.println("Invalid time format. Please try again");
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
        
        char confirm;
        do{
            System.out.print("Confirm Rental and pay deposit? (Y/N): ");
            String c = sc.nextLine();
            
            if(c.length() == 1){
                confirm = c.charAt(0);
            }else{
                confirm = 'X';
            }
            
            if(confirm == 'N'){
                System.out.println("\nBooking cancel. Return to Menu...");
                break;
            }
        }while(confirm != 'Y' && confirm != 'N');
        
        
        
    }

    private static void returnBicycle(Customer customer) {
       
    }

}
