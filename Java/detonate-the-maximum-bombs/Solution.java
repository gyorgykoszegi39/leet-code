import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private int count;
    public int maximumDetonation(int[][] bombs) {
        int maximumDetonations = 0;
        for(int i = 0; i < bombs.length; i++) {
            count = 1;
            dfs(bombs, new boolean[bombs.length], i);
            maximumDetonations = Math.max(maximumDetonations, count);
        }
        
        return maximumDetonations;
    }

    public void dfs(int[][] bombs, boolean[] visited, int node) {
        visited[node] = true;
        count++;
       
        for(int i = 0; i < bombs.length; i++) {
            if(!visited[i] && isDetonating(bombs[node], bombs[i])) {
                dfs(bombs, visited, i);
            }
        }
    }

    private boolean isDetonating(int bomb1[], int bomb2[]) {
        long dx = bomb1[0] - bomb2[0];
        long dy = bomb1[1] - bomb2[1];
        long r = bomb1[2];
        return r * r >= dx * dx + dy * dy;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumDetonation(new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
        System.out.println(s.maximumDetonation(new int[][] {{54,95,4},{99,46,3},{29,21,3},{96,72,8},{49,43,3},{11,20,3},{2,57,1},{69,51,7},{97,1,10},{85,45,2},{38,47,1},{83,75,3},{65,59,3},{33,4,1},{32,10,2},{20,97,8},{35,37,3}}));
        System.out.println(s.maximumDetonation(new int[][] {{7,26,7},{7,18,4},{3,10,7},{17,50,1},{3,25,10},{85,23,8},{80,50,1},{58,74,1},{38,39,7},{50,51,8},{31,99,3},{53,6,5},{59,27,10},{87,78,9},{68,58,3}}));
        System.out.println(s.maximumDetonation(new int[][] {{7,26,7},{7,18,4}, {3,25,10}}));
        System.out.println(s.maximumDetonation(new int[][] {{11961,163,5815}, {80129,9282,5139}, {14852,3206,5369}, {69565,32036,6827}}));
    }
}