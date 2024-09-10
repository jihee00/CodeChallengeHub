package week4.day2;

import java.util.Scanner;

public class Baekjoon2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalWood = 0;

            // Calculate the total amount of wood that can be obtained with current cutting height (mid)
            for (int height : trees) {
                if (height > mid) {
                    totalWood += height - mid; // Add the cut wood
                }
            }

            if (totalWood >= M) {
                result = mid; // Save the current height as a valid solution
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Output the result (maximum cutting height that gives at least M meters of wood)
        System.out.println(result);

        sc.close();
    }
}
