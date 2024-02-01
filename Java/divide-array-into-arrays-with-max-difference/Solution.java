import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length, j;
        int[][] divedNums = new int[n/3][];

        Arrays.sort(nums);
        j = 0;
        for(int i = 0; i < nums.length; i = i + 3) {
            if(nums[i + 2] - nums[i] > k)
                return new int[][] {};
            
            divedNums[j++] = new int[] { nums[i], nums[i + 1], nums[i + 2] }; 
        }

        return divedNums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] result = s.divideArray(new int[] {1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);
        
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++)
                System.out.print(result[i][j] + "  ");
            System.out.println();
        }
    }
}
