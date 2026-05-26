package graph;

import java.util.Arrays;

public class GraphMatrix {

    private int[][] adjMatrix;
    int vertices;
    GraphMatrix(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // 2 for unweighted graph
    }
    public void add(int src, int dest){
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // for undirected graph
    }

    public void showGraph(){
        for(int[] row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }

}
