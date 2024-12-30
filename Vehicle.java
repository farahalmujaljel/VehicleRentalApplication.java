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
public class Vehicle {
    private String type;
    private String model;
    private int modelYear;
    private double rentalPrice;

    //Constructor to set all vehicle details
    public Vehicle(String type, String model, int modelYear, double rentalPrice) {
        this.type = type;
        this.model = model;
        this.modelYear = modelYear;
        this.rentalPrice = rentalPrice;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getRentalPrice() {//will be used in RentalProcess
        return rentalPrice;
    }

    // Display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Vehicle Type: " + getType());
        System.out.println("Model: " + getModel() + " (" + getModelYear() + ")");
        System.out.println("Rental Price: " + getRentalPrice());//price from car and motor
    }
public static Vehicle selectVehicle(Scanner scanner) {
    Vehicle vehicle = null;

    // Outer loop to keep asking until a valid vehicle is selected
    while (vehicle == null) {
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: { //Car selection
                Car.populateCarDatabase();
                double budget = -1;

                // Inner loop to validate the budget for cars
                while (true) {
                    System.out.print("Enter your budget (125 S.R minimum): ");
                    budget = scanner.nextDouble();

                    if (Car.suggestCarsWithinBudget(budget)) {
                        // Loop for selecting a car
                        while (true) {
                            System.out.print("Select a car (number): ");
                            int carIndex = scanner.nextInt();
                            if (Car.selectCar(carIndex - 1)) {
                                vehicle = Car.selectedCar; //Car selected successfully
                                break;// Exit the car selection loop
                            } else {
                                System.out.println("----------- Try again ----------"); // Invalid car selection
                            }
                        }
                        break; // Exit the budget validation loop
                    } else {
                        System.out.println("----------- Try again ----------"); // Invalid budget message
                    }
                }
                break;
            }

            case 2: { //Motorcycle selection
                Motorcycle.loadMotors();
                double budget = -1;

                // Inner loop to validate the budget for motorcycles
                while (true) {
                    System.out.print("Enter your budget (60 S.R minimum):  ");
                    budget = scanner.nextDouble();

                    if (Motorcycle.showMotors(budget)) {
                        // Loop for selecting a motorcycle
                        while (true) {
                            System.out.print("Select a motorcycle (number): ");
                            int motorIndex = scanner.nextInt();
                            vehicle = Motorcycle.selectMotor(motorIndex - 1);
                            if (vehicle != null) {
                                break; // Exit the motorcycle selection loop
                            } else {
                                System.out.println("----------- Try again ----------"); // Invalid motorcycle selection
                            }
                        }
                        break; // Exit the budget validation loop
                    } else {
                        System.out.println("----------- Try again ----------"); // Invalid budget message
                    }
                }
                break;
            }

            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                break;
        }
    }
    return vehicle;
}
}
   
