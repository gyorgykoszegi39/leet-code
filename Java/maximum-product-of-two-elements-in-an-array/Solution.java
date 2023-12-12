public class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for(int num : nums) {
            if(max1 < num) {
                max2 = max1;
                max1 = num;
            } else if(max2 < num) {
                max2 = num;
            }
        }
        
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProduct(new int[] {3, 4, 5, 2}));
        System.out.println(s.maxProduct(new int[] {1, 5, 4, 5}));
        System.out.println(s.maxProduct(new int[] {3, 7}));
    }
}
