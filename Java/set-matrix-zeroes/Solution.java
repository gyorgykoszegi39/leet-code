
public class Solution {

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean hasRowZeros = false;

        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == 0) {
                hasRowZeros = true;
            }
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j > 0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

            if(hasRowZeros) {
                matrix[i][0] = 0;
            }
            
        }        
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }      
    }

    public static void main(String args[]) {
        // int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1,3, 1, 5}};
        // int matrix[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int matrix[][] = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
       // int matrix[][] = {{1, 1, 1}, {0, 1, 1}, {1, 1, 1}};

        Solution.printMatrix(matrix);
        Solution.setZeroes(matrix);
        Solution.printMatrix(matrix);


        
    }
    
}
