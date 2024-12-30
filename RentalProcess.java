/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclerentalapplication;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author amani
 */
public class RentalProcess {

    //fields
    private Date rentalDate;
    private Date returnDate;
    private double totalCost;
    private Customer customer;
    private Vehicle vehicle;

    //constructor
    public RentalProcess(Customer customer, Vehicle vehicle, Date rentalDate, Date returnDate) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = 0.0;
    }

    //start rental process
    public void startRental() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("\n-------------------- Rental Started --------------------");
        System.out.println("                Rental Start Date: " + dateFormat.format(rentalDate));
        System.out.println("--------------------------------------------------------");
    }

    //end rental process
    public void endRental() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        long rentalPeriod = (returnDate.getTime() - rentalDate.getTime()) / (1000 * 60 * 60 * 24);

        
        if (rentalPeriod <= 0) {
            rentalPeriod = 1; 
        }

        //calculate the total cost
        totalCost = rentalPeriod * vehicle.getRentalPrice();//price of car and motor from superclass

        System.out.println("\n-------------------- Rental Ended ----------------------");
        System.out.println("                Rental End Date: " + dateFormat.format(returnDate));
        System.out.println("--------------------------------------------------------");

        //print customer type
        if (!(customer instanceof TouristCustomer) && !(customer instanceof WalkInCustomer)) {
            System.out.println("========================================================");
            System.out.println("==========      Regular Customer Profile       ========= ");
            System.out.println("========================================================");
        } else if (customer instanceof TouristCustomer) {
            System.out.println("========================================================");
            System.out.println("==========      Tourist Customer Profile       ========= ");
            System.out.println("========================================================");
        } else if (customer instanceof WalkInCustomer) {
            System.out.println("========================================================");
            System.out.println("==========      Walk-In Customer Profile       ========= ");
            System.out.println("========================================================");
        }

        //display customer details
        System.out.println("            Customer Name: " + customer.getCustomerName());
        System.out.println("            Customer's ID : " + customer.getCustomerId());

        if (customer instanceof TouristCustomer) {
            TouristCustomer tourist = (TouristCustomer) customer;//downcast Customer customer
   
            System.out.println("            Passport Number: " + tourist.getPassportNumber());
            System.out.println("            Country of Origin: " + tourist.getTouristCountry());
        }
        
        System.out.println("            Vehicle Rented: " + vehicle.getModel());
        System.out.println("            Total Rental Days: " + rentalPeriod + " day(s)");
        System.out.println("            **** Total Cost **** : " + totalCost + " S.R");

        //discounted cost for tourist customers
        if (customer instanceof TouristCustomer) {
            double discountedCost = totalCost * (1 - TouristCustomer.specialDiscount);//1-0.10
            System.out.println("            **** Discounted Total Cost **** : " + discountedCost + " S.R");
        }
    }

    //method to parse a date+ prompt is empty
    public static Date parseDate(Scanner scanner, SimpleDateFormat dateFormat, String prompt) {
        while (true) {
            System.out.print(prompt);
            
            String input = scanner.next();
            try {
                return dateFormat.parse(input);//checks format
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    //getters and setters for total cost
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    //other getters and setters
    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}