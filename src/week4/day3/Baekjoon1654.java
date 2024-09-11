package week4.day3;

import java.util.Scanner;

public class Baekjoon1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] cables = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
            if (cables[i] > max) {
                max = cables[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalCable = 0;

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
