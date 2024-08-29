package week2.day4;

import java.util.Scanner;

public class Baekjoon1012 {

    // Directions for moving up, down, left, and right
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int M, N, K; // M: width, N: height, K: number of cabbages
    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                field[Y][X] = 1; // Mark the position of a cabbage
            }

            int wormCount = 0;

            // Finding all connected components
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (field[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount);
        }
        sc.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; // Mark the current cabbage as visited

        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
