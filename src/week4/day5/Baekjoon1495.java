package week4.day5;

import java.util.Scanner;

public class Baekjoon1495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of songs
        int S = sc.nextInt(); // Starting volume
        int M = sc.nextInt(); // Maximum volume
        int[] V = new int[N]; // Volume changes for each song
        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
        }

        // Dynamic programming table: dp[i][v] represents whether it's possible
        // to play the i-th song with volume v.
        boolean[][] dp = new boolean[N + 1][M + 1];

        // Initialize the starting volume for the first song
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                // If it's possible to play the i-th song with volume j
                if (dp[i][j]) {
                    // Case 1: Increase the volume by V[i] if within bounds
                    if (j + V[i] <= M) {
                        dp[i + 1][j + V[i]] = true;
                    }
                    // Case 2: Decrease the volume by V[i] if within bounds
                    if (j - V[i] >= 0) {
                        dp[i + 1][j - V[i]] = true;
                    }
                }
            }
        }

        // Find the maximum possible volume for the last song
        int result = -1;
        for (int v = 0; v <= M; v++) {
            if (dp[N][v]) {
                result = Math.max(result, v); // Update the result with the maximum volume
            }
        }
        // Output the result: maximum volume or -1 if not possible
        System.out.println(result);
        sc.close();
    }
}