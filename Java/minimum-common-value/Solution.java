public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        if (nums1[nums1.length - 1] < nums2[j] || nums2[nums2.length - 1] < nums1[i])
            return -1;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j])
                return nums1[i];

            if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getCommon(new int[] {1, 2, 3}, new int[] {2, 4}));
    }
}