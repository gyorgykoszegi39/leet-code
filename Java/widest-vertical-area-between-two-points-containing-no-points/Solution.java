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

    public int maxWidthOfVerticalArea_2(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int maxDiff = 0;
        for(int i = 1; i < points.length; i ++)
            maxDiff = Math.max(maxDiff, points[i][0] - points[i - 1][0]);

        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxWidthOfVerticalArea(new int[][] {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}
