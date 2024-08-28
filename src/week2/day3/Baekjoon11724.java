package week2.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N + 1]; // Initialize the graph
        visited = new boolean[N + 1]; // Initialize the visited array

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Reading edges
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        // Count connected components
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    // DFS to explore the graph
    public static void dfs(int node) {
        visited[node] = true; // Mark the node as visited

        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n); // Recursively visit all connected nodes
            }
        }
    }
}
