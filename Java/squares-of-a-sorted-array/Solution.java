public class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = right, square;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }
            result[i--] = square * square;
        }
        return result;
    }

    public int[] sortedSquares1(int[] nums) {
        int[] result = new int[nums.length];
        int[] freq = new int[10001];

        for(int num : nums)
            freq[Math.abs(num)]++;

        int j = 0, square;
        for(int i = 0; i < 10001; i++) {
            if(freq[i] > 0) {
                square = i * i;
                while(freq[i] > 0) {
                    result[j++] = square;
                    freq[i]--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.sortedSquares(new int[] {-7, -3, 2, 3, 11}))
            System.out.println(num + " ");
    }
}