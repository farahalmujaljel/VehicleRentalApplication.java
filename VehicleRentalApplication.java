/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiclerentalapplication;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author amani
 */
public class VehicleRentalApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main interface
        System.out.println("==================================================================================");
        System.out.println("================== Welcome To Java Vehicle Rental Application ====================");
        System.out.println("================== Help our team to find your best choice ========================");
        System.out.println("=================== Select your customer type to proceed =========================");
        System.out.println("==================================================================================");
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("1. Regular Customer: If you are a returning customer.");
        System.out.println("2. Tourist Customer: If you are visiting from another country or city.");
        System.out.println("3. Walk-In Customer: If you are renting a car without prior registration.");
        System.out.println("----------------------------------------------------------------------------------");

        
        Customer customer = null;
        while (customer == null) {
            System.out.print("========= Please enter the number corresponding to your choice (1 - 2 - 3) ========: ");
            int customerType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n");

            switch (customerType) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("===================================================================================");
                    System.out.println("=============            You selected Regular Customer           ==================");
                    System.out.println("===================================================================================");
                    System.out.println("-----------------------------------------------------------------------------------");
                    
                    
                    customer = new Customer(   //creates object + (Error Handling)from Customer superclass
                            Customer.getValidName(scanner),
                            Customer.getValidPhoneNumber(scanner),
                            Customer.getValidAge(scanner),
                            Customer.getValidID(scanner)
                    ); 
                    break;

                case 2:
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("===================================================================================");
                    System.out.println("=============            You selected Tourist Customer           ==================");
                    System.out.println("===================================================================================");
                    System.out.println("-----------------------------------------------------------------------------------");
                    
                    
                    customer = new TouristCustomer(     //creates object + (Error Handling)from Customer superclass
                            Customer.getValidName(scanner),
                            Customer.getValidPhoneNumber(scanner),
                            Customer.getValidAge(scanner),
                            Customer.getValidID(scanner),
                            Customer.getValidPassportNumber(scanner),
                            Customer.getValidCountry(scanner)
                    );
                    break;

                case 3:
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("===================================================================================");
                    System.out.println("=============            You selected Walk-In Customer           ==================");
                    System.out.println("===================================================================================");
                    System.out.println("-----------------------------------------------------------------------------------");
                    WalkInCustomer walkInCustomer = new WalkInCustomer(//creates object 
                            Customer.getValidName(scanner) //creates object + (Error Handling)from Customer superclass
                            ,Customer.getValidPhoneNumber(scanner)
                            ,0,//default age for walk-in
                            " "); //No customer ID for walk-in                   
                    walkInCustomer.viewProfile();
                    return;

                default:
                    System.out.println("Invalid input! Please enter 1, 2, or 3.\n");
                    break;
            }
        }

        //Vehicle selection
        System.out.println("\n=========================================================");
        System.out.println("                Vehicle Rental Options                  ");
        System.out.println("=========================================================");
        System.out.println("1. Rent a Car\n2. Rent a Motorcycle");

        Vehicle vehicle = Vehicle.selectVehicle(scanner); //call selectVehicle from the Vehicle superclass to check if user input 1 or 2
       

        // Rental process
        System.out.println("\n=========================================================");
        System.out.println("                    Rental Process                       ");
        System.out.println("=========================================================");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);//keyword before is within date import. used to logical date entry.

        Date rentalStartDate;
        Date rentalEndDate;

        //validate date range+prompt
        while (true) {
            rentalStartDate = RentalProcess.parseDate(scanner, dateFormat, "Enter rental start date (yyyy-MM-dd): ");
            rentalEndDate = RentalProcess.parseDate(scanner, dateFormat, "Enter rental end date (yyyy-MM-dd): ");

            if (!rentalEndDate.before(rentalStartDate)) { //keyword before is within date import
                break;//if the date is correct then the value of both start and end is calculated in rental period
            } else {
                System.out.println("Invalid date range.");
            }
        }

        

        //start rental process
        RentalProcess rental = new RentalProcess(customer, vehicle, rentalStartDate, rentalEndDate);
        rental.startRental();
        rental.endRental();

        //final success message
        System.out.println("=========================================================");
        System.out.println("               Vehicle rented successfully               ");
        System.out.println("=========================================================");
        System.out.println("  Thank you for using our Vehicle Rental Application.");
        System.out.println("     Drive carefully and embrace every journey!");
        System.out.println("\n");
        System.out.println("        ______                 Vehicle Rental Application Team:");
        System.out.println("       /|_||_\\`.__             Amani Saeed Alghamdi.");
        System.out.println("      (   _    _ _\\            Farah Mustafa Almujaljel.");
        System.out.println("      =`-(_)--(_)-'            Khayal Suliman Alnomis.");
        System.out.println("        |       |              Reemas Tariq Aleid.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---------     ---------     ");
        System.out.println("     ---------     ---------");
        System.out.println("---------     ---------     ");
    }
}