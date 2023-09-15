import java.util.HashSet;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> connectedPoints = new HashSet<>();
        int n = points.length, result = 0, dist[] = new int[n], connectNeighbor;
        connectedPoints.add(0);
        dist[0] = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            dist[i] = calculateDistance(points, 0, i);
        }

        while(connectedPoints.size() != n) {
            connectNeighbor = 1;

            for(int i = 1; i < n; i++) {
                if(dist[connectNeighbor] > dist[i]) {
                    connectNeighbor = i;
                }
            }

            System.out.println(connectNeighbor);
            connectedPoints.add(connectNeighbor);
            result += dist[connectNeighbor];
            dist[connectNeighbor] = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                if(!connectedPoints.contains(i)) {
                    dist[i] = Math.min(dist[i], calculateDistance(points, connectNeighbor, i));
                }
            }
        }

        return result;
    }

    public int calculateDistance(int[][] points, int p1, int p2) {
        return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostConnectPoints(new int[][] {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }
}
