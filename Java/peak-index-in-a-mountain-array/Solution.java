public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid = (left + right) / 2;
        while(left < right) {
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid+1])
                return mid;
            if(arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        
        return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(s.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(s.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(s.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));


    }
}
