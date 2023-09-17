import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int lastMask = (1 << n) - 1;
        Queue<int[]> visitNodes = new LinkedList<>();
        boolean[][] visited = new boolean[n][lastMask + 1];

        int[] node;
        for(int i = 0; i < n; i++) {
            visitNodes.add(new int[] {i, 1 << i, 0});
            visited[i][1 << i] = true;
        }

        while(!visitNodes.isEmpty()) {
            node = visitNodes.poll();
            if(node[1] == lastMask)
                return node[2];

            for(int i = 0; i < graph[node[0]].length; i++) {
                int visitNode[] = new int[3];
                visitNode[0] = graph[node[0]][i];;
                visitNode[1] = node[1] | (1 << visitNode[0] );;
                visitNode[2] = node[2] + 1;
                if(!visited[visitNode[0]][visitNode[1]]) {
                    visitNodes.add(visitNode);
                    visited[visitNode[0]][visitNode[1]] = true;
                }
            }
        }

        return 111111;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shortestPathLength(new int[][] {{1, 2, 3}, {0}, {0}, {0}}));
        System.out.println(s.shortestPathLength(new int[][] {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }
}
