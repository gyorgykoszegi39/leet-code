public class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] countOnes = new int[m];
        countOnes[0] = n;
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                countOnes[j] += (grid[i][0] == 1 ? grid[i][j] : 1 - grid[i][j]); 
            }
        }
        int sum = 0, power = 1;

        for(int j = m - 1; j >= 0; j--) {
            sum += Math.max(countOnes[j], n - countOnes[j]) * power;
            power *= 2;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.matrixScore(new int[][] {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
