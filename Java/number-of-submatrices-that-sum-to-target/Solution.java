import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, count = 0, sum;
        Map<Integer, Integer> countPrefix = new HashMap<>();

        for(int i = 0; i < n; i++)
            for(int j = 1; j < m; j++)
                matrix[i][j] += matrix[i][j - 1];

        for(int col1 = 0; col1 < m; col1++) {
            for(int col2 = col1; col2 < m; col2++) {
                countPrefix.clear();
                countPrefix.put(0, 1);
                sum = 0;
                for(int i = 0; i < n; i++) {
                    sum += matrix[i][col2] - (col1 > 0 ? matrix[i][col1 - 1] : 0);
                    count += countPrefix.getOrDefault(sum - target, 0);
                    countPrefix.put(sum, countPrefix.getOrDefault(sum , 0) + 1);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numSubmatrixSumTarget(new int[][] {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
    }
}
