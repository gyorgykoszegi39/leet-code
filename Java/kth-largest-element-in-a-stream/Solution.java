import java.util.Collections;
import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<Integer>();
        for(int num : nums) {
            this.priorityQueue.add(num);
        }

        while(this.k < this.priorityQueue.size())
            this.priorityQueue.poll();
    }
    
    public int add(int val) {
        this.priorityQueue.add(val);

        if(this.k < this.priorityQueue.size())
            this.priorityQueue.poll();

        return this.priorityQueue.peek();
    }
}

public class Solution {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2});

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }
    
}
