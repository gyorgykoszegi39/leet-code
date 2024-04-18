public class Solution {

    public int islandPerimeter(int[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count += 4;

                    if(i > 0 && grid[i - 1][j] == 1)
                        count -= 2;

                    if(j > 0 && grid[i][j - 1] == 1)
                        count -= 2;
                }
            }
        }
            
        return count;
    }

    public int islandPerimeter1(int[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count += i == 0 || grid[i - 1][j] == 0 ? 1 : 0;
                    count += i == n - 1 || grid[i + 1][j] == 0 ? 1 : 0;
                    count += j == 0 || grid[i][j - 1] == 0 ? 1 : 0;
                    count += j == m - 1 || grid[i][j + 1] == 0 ? 1 : 0;
                }
            }
        }
            
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }
}
