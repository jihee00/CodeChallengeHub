package week4.day1;

import java.util.Arrays;

public class ProImmigration {

    // Function to find the minimum time required for all people to pass immigration
    public static long solution(int n, int[] times) {
        // left is the minimum possible time, which is 1 minute
        // right is the maximum possible time, which is when the slowest officer processes all people
        long left = 1;
        long right = (long) n * Arrays.stream(times).max().getAsInt();
        long answer = right;

        // Binary search to find the minimum time
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            // Calculate the total number of people that can be processed within mid time
            for (int time : times) {
                total += mid / time;
            }

            // If the total number of people processed is greater than or equal to n
            // try to reduce the time by updating right
            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                // If the total is less than n, increase the time by updating left
                left = mid + 1;
            }
        }

        return answer; // Return the minimum time found
    }

    public static void main(String[] args) {
        // Example test case
        int n = 6;
        int[] times = {7, 10};

        // Print the result of the solution
        System.out.println(solution(n, times));  // Output: 28
    }
}
