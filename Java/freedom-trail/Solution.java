import java.util.Arrays;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];

        return findMinStep(dp, ring.toCharArray(), 0, key.toCharArray(), 0);
    }

    private int findMinStep(int[][] dp, char[] ring, int position, char[] key, int next) {
        if(next == key.length)
            return 0;

        if(dp[next][position] != 0)
            return dp[next][position];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length; i++) {
            if(ring[i] == key[next]) {
                int dist = Math.abs(position - i);
                dist = Math.min(dist, ring.length - dist);
                min = Math.min(min, 1 + dist + findMinStep(dp, ring, i, key, next + 1));
            }
        }

        dp[next][position] = min;

        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findRotateSteps("godding", "gd"));
        System.out.println(s.findRotateSteps("godding", "godding"));
        System.out.println(s.findRotateSteps("abcde", "ade"));
        System.out.println(s.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
