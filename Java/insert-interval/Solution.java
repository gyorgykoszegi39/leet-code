import java.util.ArrayList;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> resultList = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean first = true;
        for(int[] interval : intervals) {
            if(interval[0] < newInterval[0] && interval[1] < newInterval[0])
                resultList.add(interval);
            else if(interval[0] > newInterval[0] && interval[0] > newInterval[1]) {
                if(first) {
                    resultList.add(new int[]{left, right});
                    first = false;
                }
                resultList.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        
        if(first) {
            resultList.add(new int[] {left, right});
        }          
        
        int[][] result = new int[resultList.size()][2];
        int i = 0;
        for(int[] interval : resultList)
            result[i++] = interval;

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] result = s.insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5});

        for(int[] row : result) {
            for(int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
