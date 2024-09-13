package week4.day3;

import java.util.Scanner;

public class Baekjoon1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // K: Number of available cables, N: Number of cables to be made
        int K = sc.nextInt();
        int N = sc.nextInt();
        // Array to store the length of each cable
        int[] cables = new int[K];
        // Variable to store the maximum length of the cables
        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
            if (cables[i] > max) {
                max = cables[i];
            }
        }

        // Initializing the binary search boundaries
        long left = 1; // Minimum possible length
        long right = max; // Maximum possible length
        long result = 0; // Variable to store the final answer

        // Binary search to find the maximum length of cable that can produce at least N cables
        while (left <= right) {
            long mid = (left + right) / 2; // Midpoint of current search space
            long totalCable = 0; // Total number of cables that can be made with 'mid' length

            // Calculate how many cables can be made with the current mid length
            for (int cable : cables) {
                totalCable += cable / mid; // Count how many cables of length mid can be made
            }

            // If we can make at least N cables
            if (totalCable >= N) {
                result = mid; // Save the current length as a valid solution
                left = mid + 1; // Try for a longer cable
            } else {
                right = mid - 1; // Try for a shorter cable
            }
        }

        System.out.println(result);
        sc.close();
    }
}
