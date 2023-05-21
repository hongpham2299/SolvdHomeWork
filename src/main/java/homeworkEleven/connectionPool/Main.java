package homeworkEleven.connectionPool;

import homeWorkTen.reflection.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args)  {

        Logger logger = LogManager.getLogger(Main.class.getName());

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        //Creating 7 threads
        ExecutorService service = Executors.newFixedThreadPool(7);

        //5 threads should be able to get the connection first
        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    logger.info("Thread: " + Thread.currentThread().getId() + ", Connection acquires: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    logger.info("Thread: " + Thread.currentThread().getId() + ", Connection releases: " + connection);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            });
        }

        //2 Threads should wait for the next available connection
        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    logger.info("Waiting Thread: " + Thread.currentThread().getId() + ", Connection acquires: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    logger.info("Waiting Thread: " + Thread.currentThread().getId() + ", Connection releases: " + connection);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            });

        }
        service.shutdown();

    }



}
