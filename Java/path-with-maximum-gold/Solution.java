public class Solution {
    public int getMaximumGold(int[][] grid) {
        int result = justGold(grid);
        
        if(result > 0)
            return result;
        result = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                result = Math.max(result, DFS(grid, i, j));
        return result;
    }

    public int justGold(int[][] grid){
        int c = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    return -1;
                c += grid[i][j];
            }
        }
        return c;
    }

    public int DFS(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;

        if(grid[i][j] <= 0)
            return 0;

        int result = grid[i][j];
        grid[i][j] *= -1;

        int top = DFS(grid, i - 1, j);
        int bottom = DFS(grid, i + 1, j);
        int left = DFS(grid, i, j - 1);
        int right = DFS(grid, i, j + 1);

        result += Math.max(Math.max(top, bottom), Math.max(left, right));
        grid[i][j] *= -1;

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getMaximumGold(new int[][] {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(s.getMaximumGold(new int[][] {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }
}
