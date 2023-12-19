public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = 0;
                int startP = (i - 1) < 0 ? 0 : (i - 1);
                int endP = i + 1 == n ? i : i + 1;
                int startL = (j - 1) < 0 ? 0 : (j - 1);
                int endL = j + 1 == m ? j : j + 1;
                for(int p = startP; p <= endP; p++) {
                    for(int l = startL; l <= endL; l++) {
                        sum += img[p][l];
                    }
                }

                result[i][j] = sum / ((endP - startP + 1) * (endL - startL + 1));
            }
        }

        return result;
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

        int[][] img = new int[][] {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        img = s.imageSmoother(img);
        s.printMatrix(img);
        
    }
}
