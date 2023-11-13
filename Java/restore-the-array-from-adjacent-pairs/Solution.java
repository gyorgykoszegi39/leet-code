import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int margin = -1_000_000_007;
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] nums = new int[n + 1], nextVal;
        Map<Integer, int[]> linkedNums = new HashMap<Integer, int[]>();

        for(int i = 0; i < n; i++) {
            if(linkedNums.containsKey(adjacentPairs[i][0])) {
                linkedNums.get(adjacentPairs[i][0])[1] = adjacentPairs[i][1];            
            } else {
                linkedNums.put(adjacentPairs[i][0], new int[] {adjacentPairs[i][1], margin});            
            }

            if(linkedNums.containsKey(adjacentPairs[i][1])) {
                linkedNums.get(adjacentPairs[i][1])[1] = adjacentPairs[i][0];            
            } else {
                linkedNums.put(adjacentPairs[i][1], new int[] {adjacentPairs[i][0], margin});            
            }
        }

        int first = 0;
        for( Map.Entry<Integer, int[]> entry : linkedNums.entrySet()) {
            if(entry.getValue()[1] == margin) {
                first = entry.getKey();
                break;
            }
        }
        int prev = margin;

        nums[0] = first;
        nextVal = linkedNums.get(first);
        nums[1] = prev == nextVal[0] ? nextVal[1] : nextVal[0];
        for(int i = 2; i <= n; i++) {
            nextVal = linkedNums.get(nums[i - 1]);
            nums[i] = nums[i - 2] == nextVal[0] ? nextVal[1] : nextVal[0];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        for(int num : s.restoreArray(new int[][] {{2, 1}, {3, 4}, {3, 2}})) {
            System.out.print(num +  " ");
        }
        System.out.println();
        for(int num : s.restoreArray(new int[][] {{100000, -100000}})) {
            System.out.print(num + " ");
        }
    }
}
