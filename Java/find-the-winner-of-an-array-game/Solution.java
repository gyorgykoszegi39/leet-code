
public class Solution {
    public int getWinner(int[] arr, int k) {
        int count = 0, max = arr[0];

        for(int i = 1; i < arr.length && count < k; i++) {
            if(max < arr[i]) {
                count = 0;
                max = arr[i];
            }
            count++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getWinner(new int[] {2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(s.getWinner(new int[] {3, 2, 1}, 10));
    }
}
