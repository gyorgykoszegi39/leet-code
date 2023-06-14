import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        Map<String, Integer> pairs = new HashMap<String, Integer>();

        for(int column = 0; column < n; column++) {
            char[] columnArray = new char[n];
            for(int row = 0; row < n; row++)
                columnArray[row] = (char) grid[row][column];
            String key = String.valueOf(columnArray);
            pairs.put(key, pairs.getOrDefault(key, 0) + 1);
        }

        for(int row = 0; row < n; row++) {
            char[] rowArray = new char[n];
            for(int column = 0; column < n; column++)
                rowArray[column] = (char) grid[row][column];
            count += pairs.getOrDefault(String.valueOf(rowArray), 0);
        }

        return count;
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
