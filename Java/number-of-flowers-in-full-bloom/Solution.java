import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int count = 0;
        Queue<int[]> sweepLine = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < people.length; i++)
            sweepLine.offer(new int[] {people[i], 1, i});

        for(int i = 0; i < flowers.length; i++) {
            sweepLine.offer(new int[] {flowers[i][0], 0});
            sweepLine.offer(new int[] {flowers[i][1], 2});
        }

        while(!sweepLine.isEmpty()) {
            int[] event = sweepLine.poll();

            if(event[1] == 0) {
                count++;
            } else if (event[1] == 2){
                count--;
            } else {
                people[event[2]] = count;
            }
        }
        
        return people;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int r : s.fullBloomFlowers(new int[][] {{1, 6}, {3, 7},{9, 12}, {4, 13}}, new int[] {2, 3, 7, 11})) {
            System.out.println(r);
        }
    }
}
