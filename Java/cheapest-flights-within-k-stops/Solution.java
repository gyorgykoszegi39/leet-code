import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src] = 0;
        for(int i = 0; i <= k; i++)
        {
            int[] tmp = Arrays.copyOf(costs, n);
            for(int[] flight: flights)
            {
                if(costs[flight[0]] == Integer.MAX_VALUE)
                    continue;
                tmp[flight[1]] = Math.min(tmp[flight[1]], costs[flight[0]] + flight[2]);
            }
            costs = tmp;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    //Dijkstra
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> connections = new HashMap<>();
        PriorityQueue<int[]> neighbours = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));

        for (int[] flight : flights) {
            connections.putIfAbsent(flight[0], new ArrayList<>());
            connections.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        neighbours.add(new int[] {0, src, k + 1});
        while (!neighbours.isEmpty()) {
            int[] flight = neighbours.remove();

            if (flight[1] == dst) 
                return flight[0];
            
            if (flight[2] > 0) {
                if(!connections.containsKey(flight[1]))
                    continue;

                for (int[] neighbour : connections.get(flight[1])) {
                    neighbours.add(new int[] {flight[0] + neighbour[1], neighbour[0], flight[2] - 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findCheapestPrice(4, new int[][] {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
        System.out.println(s.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(s.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(s.findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 1, 0, 0));
        System.out.println(s.findCheapestPrice(10, new int[][] {{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}
        , 6, 0, 7));
    }
}