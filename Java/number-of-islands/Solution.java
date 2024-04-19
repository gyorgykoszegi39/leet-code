public class Solution {

    public int numIslands(char[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    markIsland(grid, i, j, n, m);
                }
            }
        }
            
        return count;
    }

    void markIsland(char[][] grid, int i, int j, int n, int m) {
        if(i < 0 || i == n || j < 0 || j == m)
            return;

        if(grid[i][j] != '1')
            return;

        grid[i][j] = '2';

        markIsland(grid, i + 1, j, n, m);
        markIsland(grid, i - 1, j, n, m);
        markIsland(grid, i, j + 1, n, m);
        markIsland(grid, i, j - 1, n, m);
    }

    void printGrid(char[][] grid) {
        System.out.println();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();

        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numIslands(new char[][] {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        }));
    }
}
