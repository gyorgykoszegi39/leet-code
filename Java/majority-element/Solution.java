public class Solution {
    public int majorityElement(int[] nums) {
        int majorityNum = 0, count = 0;
        for(int num : nums) {
            if(count == 0)
                majorityNum = num;

            if(majorityNum == num)
                count++;
            else
                count--;
        }

        return majorityNum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.majorityElement(new int[] {3, 2, 3}));
        System.out.println(s.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(s.majorityElement(new int[] {6, 6, 6, 7, 7}));
        System.out.println(s.majorityElement(new int[] {10, 6, 6, 6, 10}));
        System.out.println(s.majorityElement(new int[] {1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2}));
    }
        
}