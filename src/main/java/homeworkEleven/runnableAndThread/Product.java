package homeworkEleven.runnableAndThread;

import java.util.ArrayList;
import java.util.List;

public class Product {

    //shared resource
    public static final List<Integer> bucketProduct = new ArrayList<>();

    public List<Integer> getBucketProduct() {
        return bucketProduct;
    }
}
