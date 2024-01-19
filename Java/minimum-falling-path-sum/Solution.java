import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int row = matrix.length - 2; row >= 0; row--) {
            for(int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] += getMinFallingPath(matrix, row + 1, col);
            }
        }
        
        int min = matrix[0][0];
        for(int col = 0; col < matrix[0].length; col++)
            if(matrix[0][col] < min)
                min = matrix[0][col];
            
        //min = Arrays.stream(matrix[0]).reduce(Integer.MAX_VALUE, Integer::min);

        return min;
    }

    private int getMinFallingPath(int[][] matrix, int row, int col) {
        if(col == 0)
            return Math.min(matrix[row][col], matrix[row][col + 1]);
        if(col == matrix[0].length - 1)
            return Math.min(matrix[row][col - 1], matrix[row][col]);

        return Math.min(matrix[row][col - 1], Math.min(matrix[row][col], matrix[row][col + 1]));
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minFallingPathSum(new int[][] {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }
}
