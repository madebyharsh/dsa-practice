package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphList {

    private List<List<Integer>> adjList;
    int vertices;

    GraphList(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void add(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void showGraph(){
        for(List<Integer> edge: adjList){
            System.out.println(edge);
        }
    }
}
