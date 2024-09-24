package graphs;

import java.util.LinkedList;

public class BFS {
    public static void mainFn() {
        bfsTraversal();
    }

    public static void bfsTraversal(){
        int vertices = 4;
        Graph graph = createGraph(vertices);
        int startPoint = 0;
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("BFS Traversal");
        list.add(startPoint);
        while (!list.isEmpty()) {
            int element = list.remove();
            System.out.print(element + " ");
            LinkedList<Integer> currentList = graph.lists[element];
            for(Integer listElement:currentList){
                if(!visited[listElement]) {
                    list.add(listElement);
                    visited[listElement] = true;
                }
            }
        }
        System.out.println();
    }

    public static Graph createGraph(int vertices){
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        return graph;
    }
}
