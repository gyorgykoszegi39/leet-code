public class Solution {

    public int minFallingPathSum(int[][] grid) {
        int min, min2, minIndex, n = grid.length - 1;
        for(int i = 0; i < n; i++) {
            min = 100;
            min2 = 100;
            minIndex = -1;
            for(int j = 0; j <= n; j++) {
                if(min > grid[i][j]) {
                    min2 = min;
                    minIndex = j;
                    min = grid[i][j];
                } else if(min2 > grid[i][j]) {
                    min2 = grid[i][j];
                }
            }

            for(int j = 0; j <= n; j++) {
                grid[i + 1][j] += min;
            }

            grid[i + 1][minIndex] += min2 - min;
        }

        min = grid[n][0];
        for(int j = 1; j <= n; j++) {
            min = Math.min(min, grid[n][j]);
        }
        return min;
    }

    private void printGrid(int[][] grid) {
        int n = grid.length;

        System.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minFallingPathSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
