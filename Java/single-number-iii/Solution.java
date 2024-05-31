public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int[] result = new int[2];

        for(int num : nums)
            diff = diff ^ num;

        diff = (diff & (diff - 1) ) ^ diff;
        for(int num : nums){
            if((num & diff) == 0)
                result[0] = result[0] ^ num;
            else
                result[1] = result[1] ^ num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.singleNumber(new int[] {1, 2, 1, 3, 2, 5});
        System.out.println(result[0] + "  " + result[1]);
    }
}
