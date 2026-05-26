package graph;

import java.util.*;

public class GraphList implements Graph{

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
    public boolean bfs(int start, int value){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            List<Integer> edges = adjList.get(queue.poll());
            for(Integer edge: edges){
                if(edge == value) return true;
                if(visited[edge]) continue;
                visited[edge] = true;
                queue.offer(edge);
            }
        }
        return false;
    }
}
