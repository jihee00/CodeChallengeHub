package week3.day1;

import java.util.Scanner;

public class Baekjoon15651 {
    static int N, M;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        output = new int[M];

        dfs(0);
        System.out.println(sb.toString());
        sc.close();
    }

    static void dfs(int length) {
        if (length == M) { // If the sequence is complete, add to StringBuilder
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            output[length] = i;  // Store the current level
            dfs(length + 1); // Move to the next level
        }
    }
}
