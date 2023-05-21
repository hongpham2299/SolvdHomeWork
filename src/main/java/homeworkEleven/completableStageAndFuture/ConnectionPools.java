package homeworkEleven.completableStageAndFuture;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPools {

    private BlockingQueue<Connection> pool;
    private static final int poolSize = 5;
    private static volatile ConnectionPools instance;

    public ConnectionPools() {
        pool = new LinkedBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.add(new Connection());
        }
    }

    public Connection getConnection()  {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        pool.add(connection);
    }

    public static ConnectionPools getInstance() {
        if (instance == null) {
            synchronized (ConnectionPools.class) {
                if (instance == null) {
                    instance = new ConnectionPools();
                }
            }
        }
        return instance;
    }

    public Future<Connection> getConnectionAsync() {
        CompletableFuture<Connection> future = new CompletableFuture<>();

        try {
            Connection connection = pool.take();
            future.complete(connection);
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }
        return future;
    }

}
