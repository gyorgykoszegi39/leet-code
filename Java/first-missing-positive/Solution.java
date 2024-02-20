public class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length, tmp, i = 0;

        while(i < n) {
            if(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            } else 
                i++;
        }

        for(i = 0; i < n; i++)
            if(nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        boolean[] numbers = new boolean[n + 1];
        for(int num : nums) {
            if(num > 0 && num <= n)
                numbers[num] = true;
        }

        for(int i = 1; i <= n; i++)
            if(!numbers[i])
                return i;

        return n + 1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstMissingPositive(new int[] {1}));
        System.out.println(s.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(s.firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(s.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }    
}
