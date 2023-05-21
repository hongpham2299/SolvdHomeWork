package homeworkEleven.completableStageAndFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(Main.class.getName());

        ConnectionPools connectionPool = ConnectionPools.getInstance();

        //Creating 7 threads
        ExecutorService service = Executors.newFixedThreadPool(7);

        //5 threads should be able to get the connection first
        CompletableFuture<Void>[] fiveThreads = new CompletableFuture[5];
        for (int i = 0; i < 5; i++) {
            fiveThreads[i] = CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    logger.info("Thread: " + Thread.currentThread().getId()
                                                  + ", Connection acquires: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    logger.info("Thread: " + Thread.currentThread().getId()
                                                  + ", Connection releases: " + connection);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }, service);
        }

        //2 Threads should wait for the next available connection
        CompletableFuture<Void>[] twoThreads = new CompletableFuture[2];
        for (int i = 0; i < 2; i++) {
            twoThreads[i] = CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = connectionPool.getConnection();
                    logger.info("Waiting Thread: " + Thread.currentThread().getId()
                                                          + ", Connection acquires: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    logger.info("Waiting Thread: " + Thread.currentThread().getId()
                                                          + ", Connection releases: " + connection);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }, service);
        }

        CompletableFuture.allOf(fiveThreads).thenCompose((Void) -> CompletableFuture.allOf(twoThreads)).join();
        service.shutdown();



    }
}
