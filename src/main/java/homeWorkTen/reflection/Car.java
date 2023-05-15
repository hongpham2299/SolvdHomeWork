package homeWorkTen.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car {

    private final String name;
    private int year;

    static Logger logger = LogManager.getLogger(Car.class.getName());

    private Car(String name, int year){
        this.name = name;
        this.year = year;
    }

    private Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    private void displayName(){
        logger.info("You just invoked me: I am a private method without parameter");
    }

    private static void displayYear(){
        logger.info("You just invoked me: I am a private static method without parameter");
    }

    private void displayModelAndPrice(String model, int price){
        logger.info("You just invoked me: I am a private method with 2 parameters: " + model + " & " + price);
    }

    private void displayModel(String model){
        logger.info(model);
    }
}
