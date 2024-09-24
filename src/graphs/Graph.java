package graphs;

import java.util.LinkedList;

public class Graph {
    int vertices;
    public LinkedList<Integer>[] lists;
    Graph(int v) {
        this.vertices = v;
        lists = new LinkedList[v];
        initializeLists();
    }

    private void initializeLists(){
        for (int i=0;i<vertices;i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        lists[source].add(destination);
    }
}
