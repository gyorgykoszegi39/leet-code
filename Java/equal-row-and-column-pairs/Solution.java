
public class Solution {
    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        for(int row = 0; row < n; row++) {
            for(int column = 0; column < n; column++)
                count += isEqualRowAndColumn(grid, n, row, column);
        }
        
        return count;
    }

    private static int isEqualRowAndColumn(int[][] grid, int n, int row, int column) {
        for(int i = 0; i < n; i++) {
            if(grid[row][i] != grid[i][column])
                return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.equalPairs(new int[][] {
            { 3, 1, 2, 2}, 
            { 1, 4, 4, 5},
            { 2, 4, 2, 2},
            { 2, 4, 2, 2}
        }));
    }
}
