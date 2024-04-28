import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class Solution {

    public int[] sumOfDistancesInTree1(int n, int[][] edges) {
        int[] result = new int[n];
        Map<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();

        for(int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);;
            tree.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        Deque<Integer> neighbors = new ArrayDeque<>();
        int level, count, len;
        boolean[] visited = new boolean[n];
        for(int root = 0; root < n; root++) {
            if(result[root] != 0)
                continue;

            level = 1;
            count = 0;
            neighbors.add(root);
            Arrays.fill(visited, false);
            visited[root] = true;
            while(!neighbors.isEmpty()) {
                len = neighbors.size();
                for(int i = 0; i < len; i++) {
                    for(int next : tree.get(neighbors.poll())) {
                        if(!visited[next]) {
                            neighbors.add(next);
                            visited[next] = true;
                            count += level;
                        }
                    }
                }
                level++;
                
            }

            result[root] = count;
        }

        return result;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] result = new int[n], count = new int[n];
        int[][] tree = new int[n][];

        for (int[] edge : edges) {
            ++count[edge[0]];
            ++count[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            tree[i] = new int[count[i]];
        }
        for (int[] edge : edges) {
            tree[edge[0]][--count[edge[0]]] = edge[1];
            tree[edge[1]][--count[edge[1]]] = edge[0];
        }

        postOrderDFS(tree, 0, -1, count, result);
        preOrderDFS(tree, 0, -1, count, result);

        return result;
    }

    public void postOrderDFS(int[][] tree, int root, int parent, int[] count, int[] result) {
        count[root] = 1;
        for (int i : tree[root]) {
            if (i == parent)
                continue;
            postOrderDFS(tree, i, root, count, result);
            count[root] += count[i];
            result[root] += result[i] + count[i];
        }
    }


    public void preOrderDFS(int[][] tree, int root, int parent, int[] count, int[] result) {
        count[root] = 1;
        for (int i : tree[root]) {
            if (i == parent) 
                continue;
            result[i] = result[root] - count[i] + count.length - count[i];
            preOrderDFS(tree, i, root, count, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int sum : s.sumOfDistancesInTree(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})) {
            System.out.print(sum + " " );
        }
    }    
}
