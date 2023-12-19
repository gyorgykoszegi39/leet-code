public class Solution {
    public int maxProductDifference(int[] nums) {
        int maxA = 0, maxB = 0, minC = 10000, minD = 10000;
        
        for(int num : nums) {
            if(num > maxA) {
                maxB = maxA;
                maxA = num;
            } else if(num > maxB) {
                maxB = num;
            }

            if(num < minD) {
                minC = minD;
                minD = num;
            } else if(num < minC) {
                minC = num;
            }
        }

        return maxA * maxB - minC * minD;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProductDifference(new int[] {5, 6, 2, 7, 4}));
        System.out.println(s.maxProductDifference(new int[] {4, 2, 5, 9, 7, 4, 8}));
    }
}
