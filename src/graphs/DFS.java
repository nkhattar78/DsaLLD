package com.company.graphs;

import java.util.LinkedList;

public class DFS {
    public static void mainFn(){
        DFSTraversal();
    }

    private static void DFSTraversal(){
        int vertices = 4;
        Graph graph = createGraph(vertices);
        int startPoint = 0;
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Traversal");
        DFStraversalUtil(graph,2,visited);
        System.out.println();
    }

    private static void DFStraversalUtil(Graph graph, int element, boolean[] visitedNodes) {
        System.out.print(element + " ");
        visitedNodes[element] = true;
        LinkedList<Integer> list = graph.lists[element];
        for(int listElement:list) {
            if (!visitedNodes[listElement]) {
                DFStraversalUtil(graph, listElement, visitedNodes);
            }
        }
    }

    public static Graph createGraph(int vertices){
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        return graph;
    }
}
