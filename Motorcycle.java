/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiclerentalapplication;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author amani
 */
public class Motorcycle extends Vehicle {
    private static  List<Motorcycle> motors = new ArrayList<>();

    public Motorcycle(String brand, String model, int year, double price) {
        super(brand, model, year, price);//Passes data to the Vehicle superclass
    }
    //arraylist of motors
    public static void loadMotors() {
        motors.clear();
        motors.add(new Motorcycle("Honda", "CB500F", 2020, 60));
        motors.add(new Motorcycle("BMW", "R1250GS", 2021, 68));
        motors.add(new Motorcycle("Yamaha", "R1", 2022, 70));
        motors.add(new Motorcycle("Ducati", "Multistrada V4", 2022, 75));
        motors.add(new Motorcycle("KTM", "450 SX-F", 2023, 120));
        motors.add(new Motorcycle("Harley-Davidson", "Iron 883", 2023, 140));
    }
    //checks if budget within range
    public static boolean showMotors(double budget) {
        boolean found = false;
        for (int i = 0; i < motors.size(); i++) {
            Motorcycle motor = motors.get(i);
            if (motor.getRentalPrice() <= budget) {
                if (!found) {
                    System.out.println("\nMotorcycles within your budget:");
                }
                System.out.println((i + 1) + ". " + motor.getType() + " - " + motor.getModel() + " (" + motor.getModelYear() + ")");
                System.out.println("   Price: " + motor.getRentalPrice() + " S.R");
                found = true;
            }
        }
        return found;
    }

    public static Motorcycle selectMotor(int index) {
        if (index >= 0 && index < motors.size()) {
            return motors.get(index);
        } else {
            return null;
        }
    }
}