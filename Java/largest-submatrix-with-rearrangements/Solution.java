import java.util.Arrays;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea = 0, n = matrix.length, m = matrix[0].length;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++)
                if(matrix[i][j] != 0)
                    matrix[i][j] += matrix[i - 1][j];
        }

        for(int[] row : matrix) {
            Arrays.sort(row);
            for(int j = m - 1; j >= 0 && row[j] != 0; j--)
                maxArea = Math.max(maxArea, (m - j) * row[j]);
        }

        return maxArea;
    }

    
    private void printMatrix(int[][] matrix) {
        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }      
    }

    public static void main(String[] args) {
        Solution s =new Solution();

        System.out.println(s.largestSubmatrix(new int[][] {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
    }
}
