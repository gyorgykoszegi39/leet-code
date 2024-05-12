import java.util.Arrays;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length - 2, max;
        int[][] result = new int[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                result[i][j] = max3x3Grid(grid, i, j);

        return result;
    }

    private int max3x3Grid(int[][] grid, int i, int j) {
        int max = 0;
        for(int k = i; k < i + 3; k++)
            for(int l = j; l < j + 3; l++)
                max = Math.max(max, grid[k][l]);

        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] result = s.largestLocal(new int[][] {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}});

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
