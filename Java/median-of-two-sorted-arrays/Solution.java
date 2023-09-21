
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, mergedNums[] = new int[n + m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                mergedNums[k++] = nums1[i++];
            } else {
                mergedNums[k++] = nums2[j++];
            }
        }

        while(i < n) {
            mergedNums[k++] = nums1[i++];
        }

        while(j < m) {
            mergedNums[k++] = nums2[j++];
        }

        int mid = (n + m) / 2;

        if((n + m) % 2 == 0) 
            return (double)(mergedNums[mid - 1] + mergedNums[mid]) / 2;

        return mergedNums[mid];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[] {2}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[] {3, 4}));
    }
}
