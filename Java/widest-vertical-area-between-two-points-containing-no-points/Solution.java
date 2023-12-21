import java.util.Arrays;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] verticals = new int[n];

        for(int i = 0; i < n; i++)
            verticals[i] = points[i][0];

        Arrays.sort(verticals);
        int maxDiff = 0;
        for(int i = 1; i < n; i ++)
            maxDiff = Math.max(maxDiff, verticals[i] - verticals[i - 1]);
        
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxWidthOfVerticalArea(new int[][] {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}
