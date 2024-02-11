import java.util.Arrays;

public class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        return grid[0][0] + grid[0][m - 1] + travers(grid, dp, 0, 0, m - 1);
    }

    private int travers(int[][] grid, int dp[][][], int row, int col1, int col2) {
        if(row == grid.length - 1 || !isColumn(grid, col1) || !isColumn(grid, col2))
            return 0;
        
        if(dp[row][col1][col2] != -1)
            return dp[row][col2][col1] = dp[row][col1][col2];

        if(dp[row][col2][col1] != -1)
            return dp[row][col1][col2] = dp[row][col2][col1];

        int sum, maxSum = 0;
        int[] directions = {-1, 0, 1};
        
        for(int d1 : directions) {
            if(!isColumn(grid, col1 + d1))
                continue;

            for(int d2: directions) {
                if(!isColumn(grid, col2 + d2))
                    continue;
            
                sum = grid[row + 1][col1 + d1] + (col1 + d1 == col2 + d2 ? 0 : grid[row + 1][col2 + d2]);
                sum += travers(grid, dp, row + 1, col1 + d1, col2 + d2);
                maxSum = Math.max(maxSum, sum);
            }
        }
        

        return dp[row][col1][col2] = dp[row][col2][col1] = maxSum;
    }

    private boolean isColumn(int grid[][], int col) {
        return col >= 0 && col < grid[0].length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.cherryPickup(new int[][] {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
    }
}
