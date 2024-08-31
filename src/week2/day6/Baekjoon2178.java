package week2.day6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2178 {
    static int N, M;  // Number of rows (N) and columns (M) in the maze
    static int[][] maze;  // 2D array representing the maze
    static boolean[][] visited;  // 2D array to track visited cells
    static int[] dx = {-1, 1, 0, 0}; // Directions for moving: up, down, left, right
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading the dimensions of the maze
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        visited = new boolean[N][M];

        // Reading the maze input
        for (int i = 0; i < N; i++) {
            String line = sc.next();  // Read each line as a string
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';  // Convert characters to integers (0 or 1)
            }
        }

        // Start BFS from the top-left corner (0, 0)
        int result = bfs(0, 0);
        System.out.println(result);  // Print the minimum number of steps to reach the bottom-right corner

        sc.close();  // Close the scanner
    }

    // BFS function to find the shortest path in the maze
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();  // Queue for BFS
        queue.add(new int[]{startX, startY});  // Add the starting position to the queue
        visited[startX][startY] = true;  // Mark the starting position as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // Get the current position from the queue
            int x = current[0];
            int y = current[1];

            // If we've reached the bottom-right corner, return the number of steps
            if (x == N - 1 && y == M - 1) {
                return maze[x][y];
            }

            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // Check if the new position is within the maze bounds and is not visited
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});  // Add the new position to the queue
                    visited[nx][ny] = true;  // Mark the new position as visited
                    maze[nx][ny] = maze[x][y] + 1;  // Increment the step count for the new position
                }
            }
        }

        return -1; // This should never happen as the problem guarantees a path exists
    }
}