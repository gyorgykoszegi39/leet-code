public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = binarySearch(nums, 0, nums.length - 1, target, true);
        result[1] = result[0] == -1 ? -1 : binarySearch(nums, result[0], nums.length - 1, target, false);
        
        return result;
    }

    private int binarySearch(int nums[], int left, int right, int target, boolean leftIndex) {
        int mid, result = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid]) {
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                result = mid;
                if(leftIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)[0]);
        System.out.println(s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)[1]);
        System.out.println(s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 18)[0]);
        System.out.println(s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 18)[1]);
        System.out.println(s.searchRange(new int[] {8, 8, 8, 8, 8, 8}, 8)[0]);
        System.out.println(s.searchRange(new int[] {8, 8, 8, 8, 8, 8}, 8)[1]);
    }
}
