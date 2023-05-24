import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        long result = 0;
        long sum = 0;
        long min;
        int pairs[][] = new int[nums1.length][2];

        for(int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (p1, p2)-> Integer.compare(p2[1], p1[1]));
        PriorityQueue<Integer> priorityQueueResult = new PriorityQueue<>();
        
        for(int  i = 0; i < k - 1; i++) {
            priorityQueueResult.add(pairs[i][0]);
            sum += pairs[i][0];
        }

        priorityQueueResult.add(pairs[k - 1][0]);
        sum += pairs[k - 1][0];
        min = pairs[k - 1][1];
        result = min * sum;
        
        for(int i = k; i < nums1.length; i++) {
            if(priorityQueueResult.peek() <  pairs[i][0]) {
                sum -= priorityQueueResult.poll();
                sum += pairs[i][0];
                priorityQueueResult.add(pairs[i][0]);
                min = pairs[i][1];
                result = Math.max(result, min * sum);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.maxScore(new int[] {1,3,3,2}, new int[] {2,1,3,4}, 3));
        System.out.println(Solution.maxScore(new int[] {4,2,3,1,1}, new int[] {7,5,10,9,6}, 1));
        System.out.println(Solution.maxScore(new int[] {2,1,14,12}, new int[] {11,7,13,6}, 3));

    }
}