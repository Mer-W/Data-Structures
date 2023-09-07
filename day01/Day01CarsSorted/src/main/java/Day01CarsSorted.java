
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author mer
 */
public class Day01CarsSorted {

    public static void main(String[] args) {
        ArrayList<Car> parking = new ArrayList<>();
//  hard code car objects
//        parking.add(new Car("Toyota Prius", 1.8, 2015));
//        parking.add(new Car("Toyota Corolla", 1.8, 2021));
//        parking.add(new Car("Kia Rio", 1.6, 2018));
//        parking.add(new Car("Honda Accord", 2.5, 2015));
//        parking.add(new Car("Honda Accord", 2.4, 2013));
//        parking.add(new Car("Honda Civic", 1.5, 2017));
//        parking.add(new Car("Honda Accord", 2.5, 2017));
        readFile(parking);

        System.out.println("Print each car\n");
        for (Car car : parking) {
            System.out.print(car.toString());
        }

        // sort by make and model
        
        System.out.println("\nSort cars by make and model using comparable interface:\n");

        Collections.sort(parking);
        for (Car car : parking) {
            System.out.print(car.toString());
        }

        // sort by engine size
        
        System.out.println("\nSort cars using enginge comparator:\n");

        Comparator<Car> compareEnginge = new Comparator<Car>() {
            public int compare(Car a, Car b) {
                if (a.getEngineSizeL() < b.getEngineSizeL()) {
                    return -1;
                } else if (a.getEngineSizeL() == b.getEngineSizeL()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(parking, compareEnginge);
        for (Car car : parking) {
            System.out.print(car.toString());
        }

        
        // sort by year
        
        
        System.out.println("\nSort cars using prod year comparator:\n");

        Collections.sort(parking, (a, b) -> a.getProdYear() < b.getProdYear() ? -1 : a.getProdYear() == b.getProdYear() ? 0 : 1);
        for (Car car : parking) {
            System.out.print(car.toString());
        }
        

        // sort by year then make model
        
        
        System.out.println("\nSort cars by prod year then make model:\n");

        Collections.sort(parking, (a, b) -> a.getProdYear() < b.getProdYear() ? -1 : a.getProdYear() == b.getProdYear() ? a.compareTo(b) : 1);
        for (Car car : parking) {
            System.out.print(car.toString());
        }

    }

    static void readFile(ArrayList<Car> parking) {

        try (Scanner scanner = new Scanner(new File("cars.txt"))) {

            while (scanner.hasNext()) {
                
                String[] str = scanner.nextLine().split(";");
                
                     if (str.length != 3) {
                    System.out.println("invalid input; skipping to next line");
                    continue;
                }

                String makeModel = str[0];

                boolean isDouble;
                try {
                    Double.parseDouble(str[1]);
                    isDouble = true;
                } catch (NumberFormatException e) {
                    isDouble = false;
                }

                boolean isInt;
                try {
                    Integer.parseInt(str[2]);
                    isInt = true;
                } catch (NumberFormatException e) {
                    isInt = false;
                }

                if (makeModel != null && isDouble && isInt) {
                    
                    double engineSizeL = Double.parseDouble(str[1]);

                    int prodYear = Integer.parseInt(str[2]);

                    parking.add(new Car(makeModel, engineSizeL, prodYear));
                }

            }

            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
