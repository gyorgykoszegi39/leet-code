import java.util.Arrays;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0)
            return nums;
        int n = nums.length;
        int[] avgSum = new int[n];
        int range = 2 * k + 1;
        if(range > n) {
            Arrays.fill(avgSum, -1);
            return avgSum;
        }

        long sum = 0;
        int prevNum = 0;
        for(int i = 0; i < range - 1; i++) {
            sum += nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(i < k || i >= n - k) {
                avgSum[i] = -1;
            } else {
                sum += nums[i + k];
                sum -= prevNum;
                avgSum[i] = (int) (sum / range);
                prevNum =  nums[i - k];
            }
        }
        
        return avgSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(Integer avgSum : s.getAverages(new int[] {6643,3914,1918,9122,3503,4072,8633,5893,952,4377,1052,4513,3157,9894,9102,8734,9068,2121,4098,5039,5698,5224,2797,5440,1541,9419,9475,4465,5490,159,829,5701,314}, 5)) {
            System.out.println(avgSum);
        }
    }
}
