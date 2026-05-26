package graph;

import java.util.Arrays;

public class GraphMatrix {

    private static int[][] adjMatrix;
    int vertices;
    GraphMatrix(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // 2 for unweighted graph
    }
    public static void add(int src, int dest){
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // for undirected graph
    }

    public static void showMatrix(){
        for(int[] row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }
    static void main() {
        GraphMatrix graph = new GraphMatrix(5);
        add(0, 1);
        add(0, 4);
        add(1, 2);
        add(1, 3);
        add(1, 4);
        add(2, 3);
        add(3, 4);

        showMatrix();

    }
}
