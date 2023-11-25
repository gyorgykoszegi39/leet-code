import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        int count = 0;

        Arrays.sort(piles);

        for(int i = piles.length / 3; i < piles.length; i = i + 2)
            count += piles[i];

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxCoins(new int[] {9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }
}
