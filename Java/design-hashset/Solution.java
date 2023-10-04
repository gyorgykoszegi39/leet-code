class MyHashSet {

    private boolean buckets[][];
    private static final int bucket = 10000;
    private static final int bucketItem = 10000;

    public MyHashSet() {
        buckets = new boolean[bucket][];
    }

    private int getBucket(int key) {
        return key / bucket;
    }

    private int getBucketItem(int key) {
        return key % bucket;
    }
    
    public void add(int key) {
        int bucketKey = getBucket(key);
        int bucketKeyItem = getBucketItem(key);

        if(buckets[bucketKey] == null) {
            buckets[bucketKey] = new boolean[bucketItem];
        }

        buckets[bucketKey][bucketKeyItem] = true;
    }
    
    public void remove(int key) {
        int bucketKey = getBucket(key);
        
        if(buckets[bucketKey] != null) {
            int bucketKeyItem = getBucketItem(key);
            buckets[bucketKey][bucketKeyItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucketKey = getBucket(key);

        if(buckets[bucketKey] == null) {
            return false;
        }

        int bucketKeyItem = getBucketItem(key);
        
        return buckets[bucketKey][bucketKeyItem];
    }
}

public class Solution {
    
    public static void main(String[] args) {

        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.remove(2);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
    }
}
