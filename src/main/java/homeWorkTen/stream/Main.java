package homeWorkTen.stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(Main.class.getName());

        //ArrayList
        List<String> vehicle = Arrays.asList("bus", "bicycle", "car", "bus", "bike", "train", "car");
        List<String> newVehicleList = vehicle.stream()
                .filter(p-> Collections.frequency(vehicle, p)>1)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        logger.info("Find the duplicated element(s) & uppercase them -> " + newVehicleList);


        //HashSet
        Set<Integer> numbersSet = new HashSet<>();
        for(int i=0; i<6; i++){
            numbersSet.add(i+1);
        }
        numbersSet.stream().filter(p->p%2!=0)
                .sorted(Comparator.reverseOrder())
                .forEach(result-> logger.info("Print Odd numbers with reserved order -> " + result));

        //HashMap
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(21, "Alex");
        studentMap.put(27, "John");
        studentMap.put(22, "Miko");
        studentMap.put(25, "Monica");
        studentMap.put(30, "Monica");
        studentMap.put(35, "Madison");

        Map<Integer, String> studentResult = studentMap.entrySet()
                .stream()
                .filter(p-> p.getKey() >=22 && p.getValue().startsWith("M"))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        logger.info(studentResult);

        //Queue
        Queue<String> checkoutLine = new LinkedList<>();
        checkoutLine.add("Mai");
        checkoutLine.add("Bobby");
        checkoutLine.add("Lisa");
        checkoutLine.add("Maddie");
        checkoutLine.add("Bob");

        Optional<String> searchCustomers = checkoutLine.stream()
                .filter(p->p.contains("Bo"))
                .findFirst();
        logger.info(searchCustomers.get());

        //LinkedList
        List<String> animalListOne = new LinkedList<>(Arrays.asList("Peacock", "Parrot", "Crow", "Dog"));
        List<String> animalListTwo = new LinkedList<>(Arrays.asList("Dog", "Cat", "Elephant"));

        Stream<String> stream1 = animalListOne.stream();
        Stream<String> stream2 = animalListTwo.stream();

        List<String> finalList = Stream.concat(stream1, stream2)
                                        .distinct()
                                        .collect(Collectors.toList());
        logger.info("Concat 2 linkedlist, stream and distinct method -> " + finalList);

        //Vector & Array
        Vector<Integer> vectorNumList = new Vector<>(Arrays.asList(-2, 0, 4, 6, 8));
        int sum = vectorNumList.stream().reduce(10, (value1, value2) -> value1 + value2);
        logger.info("The sum of numbers -> " + sum);

        Object[] arrayString = vectorNumList.stream().toArray();
        logger.info("The length: " + arrayString.length + " -> " +  Arrays.toString(arrayString));

    }
}
