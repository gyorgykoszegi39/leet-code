public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0, j = 1;
        int[] result = new int[nums.length];
        
        for(int num : nums) {
            if(num > 0) {
                result[i] = num;
                i += 2;
            } else {
                result[j] = num;
                j += 2;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.rearrangeArray(new int[] {3, 1, -2, -5, 2, -4})) {
            System.out.print(num + " " );
        }
    }
}