import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(Integer stone : stones) {
            queue.add(stone);
        }

        while(queue.size() > 1) {
            queue.add(queue.poll() - queue.poll());
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(Solution.lastStoneWeight(stones));
    }
}
