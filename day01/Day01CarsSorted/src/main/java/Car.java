
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mer
 */
public class Car implements Comparable<Car> {

    private String makeModel;
    private double engineSizeL;
    private int prodYear;

    public Car(String makeModel, double engineSize, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSize;
        this.prodYear = prodYear;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public double getEngineSizeL() {
        return engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    @Override
    public String toString() {
        return "Make and model: " + makeModel + "\n" + "Engine size: " + engineSizeL + "L\n" + "Year: " + prodYear + "\n\n";
    }

    @Override
    public int compareTo(Car car) {
        return makeModel.compareTo(car.getMakeModel());
    }


}
