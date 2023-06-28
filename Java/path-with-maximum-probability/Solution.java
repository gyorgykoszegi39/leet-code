import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CompareProb implements Comparator<double[]> {

    @Override
    public int compare(double[] o1, double[] o2) {
        return o1[1] < o2[1] ? 1 : -1;
    }

}
public class Solution {
    public double maxProbabilityDijkstra(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, ArrayList<double[]>> mapEdges = new HashMap<Integer, ArrayList<double[]>>();

        for(int i = 0; i < edges.length; i++) {
            mapEdges.putIfAbsent(edges[i][0], new ArrayList<double[]>());
            mapEdges.putIfAbsent(edges[i][1], new ArrayList<double[]>());
            mapEdges.get(edges[i][0]).add(new double[] {edges[i][1], succProb[i]});
            mapEdges.get(edges[i][1]).add(new double[] {edges[i][0], succProb[i]});
        }

        PriorityQueue<double[]> visiteNodes = new PriorityQueue<double[]>(new CompareProb());
        visiteNodes.add(new double [] {start, 1});
        double[] visitedProb = new double[n];

        while(!visiteNodes.isEmpty()) {
            double[] currentNode = visiteNodes.poll();
            int node = (int) currentNode[0];
            if(node == end)
                return visitedProb[end];

            for(double[] neighbour : mapEdges.getOrDefault(node, new ArrayList<double[]>())) {
                int neighbourNode = (int) neighbour[0];

                if(visitedProb[neighbourNode] >= neighbour[1] * currentNode[1]) continue;

                visitedProb[neighbourNode] = neighbour[1] * currentNode[1];
                visiteNodes.add(new double[]{neighbourNode, visitedProb[neighbourNode]});
            }
        }
        return 0;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dp = new double[n];
        dp[start] = 1;
        for(int i = 0; i < n - 1; i++) {
            boolean better = false;

            for(int j = 0; j < edges.length; j++) {
                int node1 = edges[j][0];
                int node2 = edges[j][1];

                if(dp[node2] * succProb[j] > dp[node1]) {
                    dp[node1] = dp[node2] * succProb[j];
                    better = true;
                }

                if(dp[node1] * succProb[j] > dp[node2]) {
                    dp[node2] = dp[node1] * succProb[j];
                    better = true;
                }
            }

            if(!better) break;
        }
        return dp[end];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProbabilityDijkstra(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, 0.5, 0.2}, 0, 2));
        System.out.println(s.maxProbabilityDijkstra(3, new int[][]{{0, 1}}, new double[] {0.5}, 0, 2));
        System.out.println(s.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, 0.5, 0.2}, 0, 2));
        System.out.println(s.maxProbability(3, new int[][]{{0, 1}}, new double[] {0.5}, 0, 2));

    }
}
