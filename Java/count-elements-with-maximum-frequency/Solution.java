public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int count = 0, max = 0;

        for(int num : nums)
            freq[num]++;

        for(int c : freq) {
            if(max == c)
                count += max;
            if(max < c) {
                max = c;
                count = max;
            }
        }

        return count;  
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxFrequencyElements(new int[] {1, 2, 1, 2, 5}));
        System.out.println(s.maxFrequencyElements(new int[] {1, 2, 3, 4, 5}));
    }
}