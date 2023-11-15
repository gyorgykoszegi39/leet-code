import java.util.Arrays;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > count)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maximumElementAfterDecrementingAndRearranging(new int[] {1, 2, 2, 2, 1}));
        System.out.println(s.maximumElementAfterDecrementingAndRearranging(new int[] {1, 111, 111}));
        System.out.println(s.maximumElementAfterDecrementingAndRearranging(new int[] {1, 2, 3, 4, 5}));

    }
}
