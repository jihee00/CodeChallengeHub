package week2.day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {

    static final int MAX = 100001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Subin's starting position
        int K = sc.nextInt(); // Sister's position

        int[] time = new int[MAX];  // Array to store the time to reach each position

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;  // Mark the starting position as visited with initial time

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {  // If we reach the sister's position
                System.out.println(time[current] - 1);  // Output the time minus the initial offset
                return;
            }

            // Calculate the next possible positions
            int[] nextPositions = {current - 1, current + 1, 2 * current};

            for (int next : nextPositions) {
                // Check if the next position is within the valid range and has not been visited
                if (next >= 0 && next < MAX && time[next] == 0) {
                    queue.add(next);
                    time[next] = time[current] + 1;  // Increment the time for the next position
                }
            }
        }

        sc.close();
    }
}
