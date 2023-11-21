class Graph {
    private int n;
    private int[][] adjacencyMatrix;
    private static final int MAX_VALUE = 100_000_000;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adjacencyMatrix = new int[n][n];
        setAdjacencyMatrixUsingFloydWarshall(edges);
    }

    private void setAdjacencyMatrixUsingFloydWarshall(int[][] edges) {
        for(int i =0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j)
                    adjacencyMatrix[i][j] = MAX_VALUE;
        
        for(int i = 0; i < edges.length; i++)
            adjacencyMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
        
        //printAdjacencyMatrix();
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j], adjacencyMatrix[i][k] + adjacencyMatrix[k][j]);
            //printAdjacencyMatrix();
        }
    }

    private void printAdjacencyMatrix() {
        for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                    System.out.print((adjacencyMatrix[i][j] == MAX_VALUE ? "i" : adjacencyMatrix[i][j]) + " ");
            System.out.println();
        }

        System.out.println();
    }
    
    public void addEdge(int[] edge) {
        if(adjacencyMatrix[edge[0]][edge[1]] <= edge[2])
            return;
        
        adjacencyMatrix[edge[0]][edge[1]] = edge[2];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j], edge[2] + adjacencyMatrix[i][edge[0]] + adjacencyMatrix[edge[1]][j]); 
    }
    
    public int shortestPath(int node1, int node2) {
        if(adjacencyMatrix[node1][node2] == MAX_VALUE) {
            return -1;
        }
        
        return adjacencyMatrix[node1][node2];
    }
}

public class Solution {
    public static void main(String[] args) {
         Graph graph = new Graph(4, new int[][] {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int[] {1, 3, 4});
        System.out.println(graph.shortestPath(0, 3));   
    }
}
