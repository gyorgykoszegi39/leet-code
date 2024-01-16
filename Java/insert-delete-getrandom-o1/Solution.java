import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private ArrayList<Integer> values;
    private HashMap<Integer, Integer> mapping;
    private Random rand;

    public RandomizedSet() {
        values = new ArrayList<>();
        mapping = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(mapping.containsKey(val))
            return false;
        
        mapping.put(val, values.size());
        values.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!mapping.containsKey(val))
            return false;
        
        int i = mapping.get(val), n = values.size() - 1;
        if(i != n) {
            int lastValue = values.get(n);
            values.set(i, lastValue);
            mapping.put(lastValue, i);
        }
        mapping.remove(val);
        values.remove(n);

        return true;
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.remove(4));
        System.out.println(obj.getRandom());
    }    
}
