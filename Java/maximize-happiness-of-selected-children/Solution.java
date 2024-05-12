import java.util.Arrays;

public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long dec = k - 1, result = 0;

        for (int i = n - k; i < n; i++) {
            if (happiness[i] > dec)
                result += happiness[i] - dec;
            dec--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maximumHappinessSum(new int[] {1, 2, 3}, 2));
        System.out.println(s.maximumHappinessSum(new int[] {1, 1, 1, 1}, 2));
        System.out.println(s.maximumHappinessSum(new int[] {2, 3, 4, 5}, 1));
    }
}
