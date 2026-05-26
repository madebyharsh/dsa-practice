package graph;

public interface Graph {
    public void showGraph();
    public void add(int src, int dest);
    public boolean bfs(int st, int value);
}
