package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix implements Graph{

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

    public boolean bfs(int st, int value){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        queue.offer(st);
        visited[st] = true;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int i = 0; i < adjMatrix[vertex].length; i++){
                if(!visited[i] && adjMatrix[vertex][i] == 1){
                    if(i == value) return true;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false;

    }

}
