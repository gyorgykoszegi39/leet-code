
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int j, total, num, den;
        double maxFrac, left = 0, right = 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            j = 1; 
            total = 0; 
            num = 0;
            den = 0;
            maxFrac = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] >= arr[j] * mid) {
                    ++j;
                }
                
                total += n - j;

                if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
                    maxFrac = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }

            if (total == k) {
                return new int[] {arr[num], arr[den]};
            }

            if (total > k)
                right = mid;
            else
                left = mid;

        }

        return new int[] {};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.kthSmallestPrimeFraction(new int[] { 1, 2, 3, 5 }, 3);

        System.out.println(result[0] + " " + result[1]);
    }
}
