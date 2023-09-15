public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while(left <= right) {
            mid = (right - left);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[] {1, 3, 5, 6},  7));
        System.out.println(s.searchInsert(new int[] {1, 3}, 2));

    }
}
