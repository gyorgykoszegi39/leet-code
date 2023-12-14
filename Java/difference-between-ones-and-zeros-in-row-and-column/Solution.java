
public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] countRow = new int[n];
        int[] countCol = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = (n - 2 * countRow[i]) + (m - 2 * countCol[j]);
        
        return grid;
    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }      
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid1 = new int[][] {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        int[][] grid2 = new int[][] {{1, 1, 1}, {1, 1, 1}};

        grid1 = s.onesMinusZeros(grid1);
        s.printMatrix(grid1);
        System.out.println();
        grid2 = s.onesMinusZeros(grid2);
        s.printMatrix(grid2);
    }
}
