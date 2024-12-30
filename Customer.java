/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclerentalapplication;
import java.util.Scanner;

/**
 *
 * @author amani
 */
public class Customer {
    private final  String customerName;
    private final String customerPhoneNumber;
    private final int customerAge;
    private final String customerId;

    //constructor
    public Customer(String customerName, String customerPhoneNumber, int customerAge, String customerId) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAge = customerAge;
        this.customerId = customerId;
    }

    //getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public String getCustomerId() {
        return customerId;
    }

    // method to display customer information
   //is overriden in subclass WalkInCustomer 
    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone Number: " + customerPhoneNumber);
        System.out.println("Age: " + customerAge);
        System.out.println("Customer ID: " + customerId);
    }

    //Error Handling.

    public static String getValidName(Scanner input) {
        while (true) {
            System.out.print("Enter your Name: ");
            String name = input.nextLine().trim();

            if (name.matches("[A-Za-z ]+") && name.length() >= 3) {
                // Capitalize the first letter
                String[] words = name.split(" ");
                StringBuilder capitalizedName = new StringBuilder();
                for (String word : words) {
                    if (!word.isEmpty()) {
                        capitalizedName.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1).toLowerCase())
                                .append(" ");
                    }
                }
                return capitalizedName.toString().trim();
            }
            System.out.println("Invalid name. Try again.");
        }
    }
    
    //Error Handling.
    public static String getValidPhoneNumber(Scanner input) {
        while (true) {
            System.out.print("Enter your phone Number (10 digits): "); //must be 10 digit
            String phone = input.nextLine();
            if (phone.matches("\\d{10}")) return phone;
            System.out.println("Invalid phone number. Try again.");
        }
    }
    //Error Handling.
    public static int getValidAge(Scanner input) {
        while (true) {
            System.out.print("Enter your Age: ");
            if (input.hasNextInt()) { //check if integer
                int age = input.nextInt();
                input.nextLine();
                if (age >= 18) return age;
                System.out.println("Invalid age. You must be 18 or older.");
            } else {
                System.out.println("Invalid input. Please enter digits only."); // Non-integer input
                input.nextLine(); //clear invalid input
            }
        }
    }
    // Error Handling.
    public static String getValidID(Scanner input) {
        while (true) {
            System.out.print("Enter your ID (10 digits): "); //must be 10 digit
            String id = input.nextLine();
            if (id.matches("\\d{10}")) return id;
            System.out.println("Invalid ID. Try again.");
        }
    }
    // Error Handling.
    public static String getValidPassportNumber(Scanner input) {
        while (true) {
            System.out.print("Enter your passport number (1 letter followed by 8 digits): ");
            String passport = input.nextLine().trim();

            if (passport.matches("[A-Za-z]\\d{8}")) {
                // Capitalize the first letter
                String formattedPassport = passport.substring(0, 1).toUpperCase() + passport.substring(1);
                return formattedPassport;
            }
            System.out.println("Invalid passport number. It should be 1 letter followed by 8 digits.");
        }
    }
    // Error Handling.
    public static String getValidCountry(Scanner input) {
        while (true) {
            System.out.print("Enter Country: ");
            String country = input.nextLine().trim();

            if (country.matches("[A-Za-z ]+") && country.length() >= 3) {
                //capitalize the first letter of each word
                String[] words = country.split(" ");
                StringBuilder capitalizedCountry = new StringBuilder();
                for (String word : words) {
                    if (!word.isEmpty()) {
                        capitalizedCountry.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1).toLowerCase())
                                .append(" ");
                    }
                }
                return capitalizedCountry.toString().trim();
            }
            System.out.println("Invalid country name.");
        }
    }
}