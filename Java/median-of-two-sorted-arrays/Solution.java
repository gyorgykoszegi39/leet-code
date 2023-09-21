
public class Solution {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int leftMid = (n + m + 1) / 2, rightMid = (n + m + 2) / 2;

        if(leftMid == rightMid)
            return findMedian(nums1, 0, nums2, 0, leftMid);

        return (double)(findMedian(nums1, 0, nums2, 0, leftMid) + findMedian(nums1, 0, nums2, 0, rightMid)) / 2;
    }

    public int findMedian(int[] nums1, int i, int[] nums2, int j, int k) {
        int n = nums1.length, m = nums2.length;
        if(i >= n) 
            return nums2[j + k - 1];
        if(j >= m) 
            return nums1[i + k - 1];
        if(k == 1) 
            return Math.min(nums1[i], nums2[j]);

        int leftValue = i + k/2 - 1 < n ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
        int rightValue = j + k/2 - 1 < m ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;

        if(leftValue < rightValue)
            return findMedian(nums1, i + k/2, nums2, j, k - k/2); // nums1 right - nums2 left
        else
            return findMedian(nums1, i, nums2, j + k/2, k - k/2); // nums1 left - nums2 right
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[] {2}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[] {3, 4}));
    }
}
