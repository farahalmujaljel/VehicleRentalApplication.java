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

public class Car extends Vehicle {
    private static  List<Car> carDatabase = new ArrayList<>();
    static Car selectedCar;

    public Car(String type, String model, int year, double price) {
        super(type, model, year, price);//Passes data to the Vehicle superclass
    }
    //arraylist of cars
    public static void populateCarDatabase() {
        carDatabase.clear();
        carDatabase.add(new Car("Sedan", "Hyundai i10", 2023, 125));
        carDatabase.add(new Car("Sedan", "Suzuki Dzire", 2025, 135));
        carDatabase.add(new Car("SUV", "Kia Sonet", 2023, 176));
        carDatabase.add(new Car("SUV", "Nissan Kicks", 2024, 212));
        carDatabase.add(new Car("Jeep", "Chevrolet Suburban", 2019, 255));
        carDatabase.add(new Car("Sedan", "Ford Taurus", 2021, 285));
    }

    //checks if budget within range
    public static boolean suggestCarsWithinBudget(double budget) {
        boolean found = false;
        for (Car car : carDatabase) {
            if (car.getRentalPrice() <= budget) {
                if (!found) {
                    System.out.println("\nCars within your budget:");
                }
                System.out.println((carDatabase.indexOf(car) + 1) + ". " + car.getType() + " - " + car.getModel() + " (" + car.getModelYear() + ")");
                System.out.println("   Price: " + car.getRentalPrice() + " S.R");
                found = true;
            }
        }
        return found;
    }

    public static boolean selectCar(int index) {
        if (index >= 0 && index < carDatabase.size()) {
            selectedCar = carDatabase.get(index);
            return true;
        } else {
           
            return false;
        }
    }
}
