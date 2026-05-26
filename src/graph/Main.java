package graph;

import static graph.GraphMatrix.*;

public class Main {
    static void main() {
//        GraphMatrix graph = new GraphMatrix(5);
        GraphList graph = new GraphList(5);
        graph.add(0, 1);
        graph.add(0, 4);
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 3);
        graph.add(3, 4);

        graph.showGraph();

    }
}
