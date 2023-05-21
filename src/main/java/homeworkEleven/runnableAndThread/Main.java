package homeworkEleven.runnableAndThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Supplier supplierOne = new Supplier("Supplier One");
        Supplier supplierTwo = new Supplier("Supplier Two");

        Buyer buyerOne = new Buyer("Buyer One");
        Buyer buyerTwo = new Buyer("Buyer Two");

        ExecutorService service = null;
        try {
            int n = Runtime.getRuntime().availableProcessors();
            service = Executors.newFixedThreadPool(n);
            service.submit(supplierOne);
            service.submit(supplierTwo);
            service.submit(buyerOne);
            service.submit(buyerTwo);
        } finally {
            if (service !=null) {
                service.shutdown();
            }
        }



    }
}
