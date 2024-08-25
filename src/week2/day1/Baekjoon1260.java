package week2.day1;

import java.util.*;

public class Baekjoon1260 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // Number of vertices
        int M = sc.nextInt();  // Number of edges
        int V = sc.nextInt();  // Starting vertex

        // Initialize the graph
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // Sort adjacency lists to ensure that smaller numbered vertices are visited first
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // Perform DFS
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // Perform BFS
        visited = new boolean[N + 1];
        bfs(V);

        sc.close();
    }

    // Depth-First Search (DFS)
    private static void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // Breadth-First Search (BFS)
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : graph[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}
