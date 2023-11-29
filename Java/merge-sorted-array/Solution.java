public class Solution {
    public void merge(int[] nums1, int i, int[] nums2, int j) {
        int k = i + j - 1;
        i--; j--;
        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = new int[] { 1, 2, 3, 0, 0, 0};
        
        s.merge(nums, 3, new int[] {2, 5, 6},3);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
