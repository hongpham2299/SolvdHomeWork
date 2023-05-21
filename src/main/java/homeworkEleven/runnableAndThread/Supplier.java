package homeworkEleven.runnableAndThread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Supplier extends Thread {

    public Supplier(String name) {
        super(name);
    }

    Logger logger = LogManager.getLogger(Supplier.class.getName());

    @Override
    public void run() {
        try {
            Random random = new Random();
            for(int i=0; i<5; i++){
                //while (true) { //it will run infinite loop
                synchronized (Product.bucketProduct) { //decide the monitor for the block
                    if (Product.bucketProduct.size() < 5) {
                        int productNumber = random.nextInt(100);
                        Product.bucketProduct.add(productNumber);
                        Product.bucketProduct.notifyAll();
                        logger.info(Thread.currentThread().getName() + " -> "
                                + " added value: " + productNumber + " to the bucket");
                    }   else {
                        Product.bucketProduct.wait();// Supplier will wait now
                    }
                }
            }
        }   catch (InterruptedException e){
            logger.error(e.getMessage());
        }
    }
}