package datastructures.graphs;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyListArray[];

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyListArray = new LinkedList[this.vertices];

        for (int i = 0; i < this.vertices; i++) {
            this.adjacencyListArray[i] = new LinkedList<>();
        }
    }

    private void addEdge(int i, int j) {
        this.adjacencyListArray[i].add(j);
    }

    private void print() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.print(i);
            for (Integer adjacentVertex : this.adjacencyListArray[i]) {
                System.out.print(" -> " + adjacentVertex );
            }
            System.out.println("");
        }

    }

    private void bfsTraversal(int vertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.vertices];

        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            Integer vertexVisited = queue.poll();
            System.out.print(vertexVisited + " -> ");
            for (Integer adjacentVertex : adjacencyListArray[vertexVisited]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    private void dfsTraversal(int vertex) {
        boolean[] visited = new boolean[this.vertices];
        dfs(vertex, visited);
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " -> ");
        for (Integer adjacentVertex : this.adjacencyListArray[vertex]) {
            if (!visited[adjacentVertex])  dfs(adjacentVertex, visited);
        }
    }


    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 3);

        System.out.println("Graph: ");
        graph.print();

        System.out.println("Bfs Traversal");
        graph.bfsTraversal(2);
        System.out.println("");

        System.out.println("Dfs Traversal");
        graph.dfsTraversal(2);
        System.out.println("");

    }

}
