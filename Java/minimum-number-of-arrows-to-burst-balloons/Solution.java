import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int count = 1;
        int burst = points[0][1];
        
        for(int[] point : points) {
            if(point[0] >burst) {
                burst = point[1];
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(s.findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }
}
