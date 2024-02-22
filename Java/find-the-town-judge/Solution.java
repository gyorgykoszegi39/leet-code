public class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n > trust.length + 1)
            return -1;
        
        int[] everybody = new int[n + 1];

        for(int[] somebody : trust) {
            everybody[somebody[0]]--;
            everybody[somebody[1]]++;
        }

        for(int i = 1; i <= n; i++)
            if(everybody[i] == n - 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findJudge(2, new int[][] {{1, 2}}));
        System.out.println(s.findJudge(3, new int[][] {{1, 3}, {2, 3}}));
        System.out.println(s.findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}}));
    }
}
