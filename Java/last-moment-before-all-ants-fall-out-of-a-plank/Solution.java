public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;

        for(int i = 0; i < left.length; i++)
            max = Math.max(max, left[i]);
        for(int i = 0; i < right.length; i++)
            max = Math.max(max, n - right[i]);
        
            return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getLastMoment(4, new int[] {4, 3}, new int[] {0, 1}));
        System.out.println(s.getLastMoment(7, new int[] {0, 1, 2, 3, 4, 5, 6, 7}, new int[] {}));
    }
}
