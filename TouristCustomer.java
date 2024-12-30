/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclerentalapplication;

/**
 *
 * @author amani
 */
public class TouristCustomer extends Customer {
    private  String passportNumber;
    private  String touristCountry;
    public static double specialDiscount = 0.1; //10% discount
    
    //constructor
    public TouristCustomer(String customerName, String customerPhoneNumber, int customerAge, String customerId, String passportNumber, String touristCountry) {
    super(customerName, customerPhoneNumber, customerAge, customerId); //call superclass constructor
    this.passportNumber = passportNumber;
    this.touristCountry = touristCountry;
}

    //getters and setters
    public String getPassportNumber() {
        return passportNumber;
    }

    public String getTouristCountry() {
        return touristCountry;
    }
     public static void setSpecialDiscount(double discount) {
        specialDiscount = discount;
    }
 public static double applyTouristDiscount(double originalPrice) {
        return originalPrice - (originalPrice * specialDiscount);
    }
 
    //display tourist info
    public void displayTouristInfo() {
        displayCustomerInfo();
        System.out.println("Passport Number: " + passportNumber);
        System.out.println("Country of Origin: " + touristCountry);
    }
    
}
