import java.util.TreeSet;

class SmallestInfiniteSet {

    private int nextNumber = 1;
    TreeSet<Integer> treeSet = new TreeSet<Integer>();

    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        if(treeSet.isEmpty()) {
            return nextNumber++;
        } else {
            return treeSet.pollFirst();
        }
    }
    
    public void addBack(int num) {
        if(num < this.nextNumber) {
            treeSet.add(num);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
        obj.addBack(2);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(1);
        obj.addBack(1);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
    }
    
}
