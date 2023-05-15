package homeWorkTen.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

import static homeWorkTen.reflection.Car.logger;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

        /*
        Using reflection extract information(modifiers, return types, parameters, etc) about fields,
        constructors, methods. Create object and call method using the only reflection.
         */

        Class<?> carClass = Class.forName("homeWorkTen.reflection.Car");

        //Find all the constructors.
        Constructor<?>[] allConstructors = carClass.getDeclaredConstructors();
        for(Constructor<?> constructor:allConstructors) {
            //System.out.println("All Constructor(s): " + Arrays.toString(constructor.getParameterTypes()));
            logger.info("Constructor: " + Arrays.toString(constructor.getParameterTypes())
                    + ", Constructor Access Modifier: " + Modifier.toString(constructor.getModifiers()));
        }

        logger.info("------");

        //After extracting all the constructor -> Create an object for the first private constructor
        Constructor<?> privateConstructor = allConstructors[0];
        privateConstructor.setAccessible(true);
        final Car car = (Car) privateConstructor.newInstance("Honda", 2022);
        logger.info("Create an object for private constructor -> Car Name: " + car.getName()
                        + ", Car Year: " + car.getYear());

        logger.info("------");

        //Find all the fields in the Car class
        Field[] fields = carClass.getDeclaredFields();
        for(Field field:fields){
            logger.info("Field: " + field.getName() + ", Field Access Modifier: " + Modifier.toString(field.getModifiers()));
        }

        logger.info("------");

        //Update the name of the car even though the field name sets private final and no setter method
        Field field = carClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(car, "Toyota");
        logger.info("Update the name for private constructor -> Car Name: " + car.getName() + ", Car Year: " + car.getYear());

        logger.info("------");

        /*
        Find all the declared method name with modifier access, return type, parameter count,
        parameter types and the order of parameter from Car class
        */
        Method[] methods = carClass.getDeclaredMethods();
        for(Method method:methods){
            logger.info("\nMethod Name: " + method.getName() + "\n"
                    + "Access Modifier: " + Modifier.toString(method.getModifiers()) + "\n"
                    + "Return Type: " + method.getReturnType() + "\n"
                    + "Parameter Count(s): " + method.getParameterCount() + "\n");

            Parameter[] parameters = method.getParameters();
            for(Parameter parameter:parameters){
                logger.info("\nMethod Name: " + method.getName() + "\n"
                        + "Parameter Type & Oder: " + parameter.getParameterizedType() + " & "
                        + parameter.getName()+ "\n");
            }
        }

        logger.info("------");

        //Invoke a private method without parameter
        Method privateMethodWithoutParameter = carClass.getDeclaredMethod("displayName");
        privateMethodWithoutParameter.setAccessible(true);
        privateMethodWithoutParameter.invoke(car);

        logger.info("------");

        //Invoke a private method with 2 parameters
        Method privateMethodWithParameter = carClass.getDeclaredMethod("displayModelAndPrice", String.class, int.class);
        privateMethodWithParameter.setAccessible(true);
        privateMethodWithParameter.invoke(car, "HondaCRV", 32000);

        logger.info("------");

        //Invoke a private static method
        Method privateStaticMethod = carClass.getDeclaredMethod("displayYear");
        privateStaticMethod.setAccessible(true);
        privateStaticMethod.invoke(null);

    }
}
