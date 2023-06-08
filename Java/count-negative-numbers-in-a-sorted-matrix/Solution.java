
public class Solution {
    public static int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int i = 0;
        int j = m - 1;
        while(i < n) {
            while(j >= 0 && grid[i][j] < 0) {
                j--;
            }
            if(j < -1) {
                return count + (n - i) * m;
            }
            count += m - j - 1;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.countNegatives(new int[][] {{4,3,2,0},{3,2,1,0},{1,1,-1,-2},{1,-1,-2,-3}}));
    }
}
