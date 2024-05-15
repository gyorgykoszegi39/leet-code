import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size(), i, j;
        int[][] dp = findClosestThief(grid, n);

        int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[] neighbour;
        pq.add(new int[] {0, 0, dp[0][0]});
        dp[0][0] = -1;

        while (!pq.isEmpty()) {
            neighbour = pq.poll();

            if (neighbour[0] == n - 1 && neighbour[1] == n - 1) {
                return neighbour[2];
            }
            for (int[] d : direction) {
                i = d[0] + neighbour[0];
                j = d[1] + neighbour[1];

                if(i < 0 || i == n || j < 0 || j == n)
                    continue;
                if (dp[i][j] != -1) {
                    pq.add(new int[] {i, j, Math.min(neighbour[2], dp[i][j])});
                    dp[i][j] = -1;
                }
            }
        }

        return 0;
    }
    public int[][] findClosestThief(List<List<Integer>> grid, int n) {
        int[][] dist = new int[n][n];
        int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> calcDist = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    calcDist.add(new int[] {i, j});
                }
                else
                    dist[i][j] = -1;

        int neighbour[];
        int i, j, m;
        while(!calcDist.isEmpty()) {
            m = calcDist.size();

            while(m > 0) {
                neighbour = calcDist.poll();
                for(int[] d : direction) {
                    i = d[0] + neighbour[0];
                    j = d[1] + neighbour[1];

                    if(i < 0 || i == n || j < 0 || j == n)
                        continue;
                    
                    if(dist[i][j] < 0) {
                        dist[i][j] = dist[neighbour[0]][neighbour[1]] + 1;
                        calcDist.add(new int[] {i, j});
                    }
                }
                m--;
            }
        }

        return dist;
    }



    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> grid = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            grid.add(new ArrayList<>());
            for(int j = 0; j < 4; j++)
                grid.get(i).add(0);
        }


        grid.get(0).set(3, 1);
        grid.get(3).set(0, 1);

        System.out.println(s.maximumSafenessFactor(grid));
    }
}
