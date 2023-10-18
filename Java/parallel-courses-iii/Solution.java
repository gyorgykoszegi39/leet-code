import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int timeSpan = 0;
        int[] dp = new int[n];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            edges.add(new ArrayList<>());

        for(int i = 0; i < relations.length; i++) {;
            edges.get(relations[i][1] - 1).add(relations[i][0] - 1);
        }

        for(int i = 0; i < n; i++) {
            timeSpan = Math.max(timeSpan, calculateTimeSpan(i, edges, time, dp));
        }

        return timeSpan;
    }

    private int calculateTimeSpan(int node, List<List<Integer>> edges, int[] time, int[] dp) {
        if(dp[node] != 0) {
            return dp[node];
        }

        int maxTimeSpan = 0;
        for(int prevNode : edges.get(node)) {
            maxTimeSpan = Math.max(maxTimeSpan, calculateTimeSpan(prevNode, edges, time, dp));
        }
        dp[node] = maxTimeSpan + time[node];

        return dp[node];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumTime(3, new int[][] {{1, 3}, {2, 3}}, new int[] {3, 2, 5}));
        System.out.println(s.minimumTime(5, new int[][] {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}}, new int[] {1, 2, 3, 4, 5}));
    }
}
