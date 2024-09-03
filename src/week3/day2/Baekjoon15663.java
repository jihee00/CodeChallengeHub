package week3.day2;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon15663 {
    static int N, M;
    static int[] elements;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // Input the number of elements
        M = sc.nextInt(); // Input the length of the sequence
        elements = new int[N];
        output = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N ; i++) {
            elements[i] = sc.nextInt();
        }

        Arrays.sort(elements);
        dfs(0);
        System.out.print(sb.toString());

        sc.close();
    }

    static void dfs(int level) {
        // Base case: if the sequence is complete (of length M), add it to the result
        if (level == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int lastUsed = -1; // Variable to track the last used element at the current level

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (lastUsed == -1 || lastUsed != elements[i])) {
                visited[i] = true;
                output[level] = elements[i];
                lastUsed = elements[i];
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }
}
