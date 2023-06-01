import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    int i, j;
    int level;

    public Node(int i, int j, int level) {
        this.i = i;
        this.j = j;
        this.level = level;
    }
}
public class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0)
            return -1;
            
        int pathLen = 0;
        int n = grid.length - 1;

        Queue<int[]> nodes = new ArrayDeque<int[]>();
        int[][] directions = new int[][]{ {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        nodes.add(new int[] {0, 0});

        while(!nodes.isEmpty()) {
            pathLen++;

            int nodeLevel = nodes.size();
            for(int k = 0; k < nodeLevel; k++) {
                int[] node = nodes.poll();
                int i = node[0];
                int j = node[1];
                if(i == n && i == j) {
                    return pathLen;
                }

                for(int d = 0; d < 8; d++) {
                    int nextI = i + directions[d][0];
                    int nextJ = j + directions[d][1];
                    if(nextI <= n && nextJ <= n && nextI >= 0 && nextJ >= 0 && grid[nextI][nextJ] == 0) {
                        grid[nextI][nextJ] = 1;
                        nodes.add(new int[] {nextI, nextJ});
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {

       System.out.println(Solution.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1,0}}));
       System.out.println(Solution.shortestPathBinaryMatrix(new int[][] {{0,0,0}, {1,1,0}, {1,1,0}}));
       System.out.println(Solution.shortestPathBinaryMatrix(new int[][] {{1,0,0}, {1,1,0}, {1,1,0}}));
       System.out.println(Solution.shortestPathBinaryMatrix(new int[][] {{0,0,0}, {1,0,0}, {1,1,0}}));
        System.out.println(Solution.shortestPathBinaryMatrix(new int[][] {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}}));

        
    }
}
