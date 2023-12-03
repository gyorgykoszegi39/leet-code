public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;

        for(int i = 1; i < points.length; i++) {
            count += Math.max(Math.abs(points[i - 1][0] - points[i][0]), Math.abs(points[i - 1][1] - points[i][1]));
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minTimeToVisitAllPoints(new int[][] {{1, 1}, {3, 4}, {-1, 0}}));
    }
}
