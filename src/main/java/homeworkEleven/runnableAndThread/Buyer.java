package homeworkEleven.runnableAndThread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buyer implements Runnable{

    private String name;
    public Buyer(String name) {
        this.name = name;
    }

    Logger logger = LogManager.getLogger(Buyer.class.getName());

    @Override
    public void run() {
        try {
            for(int i=0; i<5; i++){
                //while(true) { //it will run infinite loop
                synchronized (Product.bucketProduct) { //decide the monitor for the block
                    if (!Product.bucketProduct.isEmpty()) {
                        int productValue = Product.bucketProduct.get(0);
                        Product.bucketProduct.remove(0);
                        Product.bucketProduct.notifyAll();
                        logger.info(Thread.currentThread().getName() + " -> "
                                + " took out the value: " + productValue + " from the bucket");
                    } else {
                        Product.bucketProduct.wait();
                    }
                }
            }
        } catch (InterruptedException e){
            logger.error(e.getMessage());
        }
    }
}

