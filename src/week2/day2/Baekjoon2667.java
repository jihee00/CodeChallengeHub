package week2.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // up, down, left, right
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                // Convert the character to an integer by subtracting '0'.
                // The ASCII value of '0' is 48, so line.charAt(j) - '0' results in 0 when the character is '0',
                // and results in 1 when the character is '1'.
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complexes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int complexSize = dfs(i, j);
                    complexes.add(complexSize);
                }
            }
        }

        // the number of complexes
        Collections.sort(complexes);
        System.out.println(complexes.size());

        // the number of houses in each complex (sorted in ascending order)
        for (int size : complexes) {
            System.out.println(size);
        }
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // Count the current house

        // Explore in all four directions
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >=0 && nx < N && ny < N) { // Check if within map bounds
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny); // Recursively count connected houses
                }
            }
        }
        return count;
    }
}
