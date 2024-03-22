public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, pLeftToRight = 1, pRightToLeft = 1;
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            result[i] = pLeftToRight;
            pLeftToRight *= nums[i];
        }
        
        for(int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * pRightToLeft;
            pRightToLeft *= nums[i];   
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.productExceptSelf(new int[] {-1, 1, 0, -3, 3}))
            System.out.print(num + " ");
    }
}
