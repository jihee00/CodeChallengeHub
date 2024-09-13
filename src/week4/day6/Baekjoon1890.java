package week4.day6;

import java.util.Scanner;

public class Baekjoon1890 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // DP table to store the number of paths to reach each cell
        long[][] dp = new long[N][N];
        // Initialize the starting point
        dp[0][0] = 1;
        // Iterate over the board to calculate possible paths
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // If we are at the bottom-right corner or if the current cell is not reachable, continue
                if (i == N - 1 && j == N - 1) break;
                if (dp[i][j] == 0 || board[i][j] == 0) continue;

                // Jump right if within bounds
                int jump = board[i][j];
                if (j + jump < N) {
                    dp[i][j + jump] += dp[i][j];
                }

                // Jump down if within bounds
                if (i + jump < N) {
                    dp[i + jump][j] += dp[i][j];
                }
            }
        }

        // Output the number of paths to the bottom-right corner
        System.out.println(dp[N - 1][N - 1]);
        sc.close();
    }
}
