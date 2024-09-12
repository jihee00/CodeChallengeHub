package week4.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon12026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String blocks = sc.nextLine();

        // Dynamic programming array to store minimum energy required to reach each block (use long to avoid overflow)
        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);  // Initialize with a large value (infinity)
        dp[0] = 0;  // Starting point requires 0 energy

        // Iterate through each block
        for (int i = 0; i < N; i++) {
            char currentBlock = blocks.charAt(i);

            // Calculate which block should be next in the sequence (B -> O -> J -> B -> ...)
            char nextBlock = getNextBlock(currentBlock);

            // Try jumping from the current block to all possible future blocks
            for (int j = i + 1; j < N; j++) {
                if (blocks.charAt(j) == nextBlock && dp[i] != Long.MAX_VALUE) {
                    long jumpDistance = j - i;
                    long energy = jumpDistance * jumpDistance;  // Energy required for this jump

                    // Update the dp table if a smaller energy value is found
                    dp[j] = Math.min(dp[j], dp[i] + energy);
                }
            }
        }

        // Output: Minimum energy required to reach the last block
        if (dp[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);  // If the last block is unreachable
        } else {
            System.out.println(dp[N - 1]);  // Minimum energy to reach the last block
        }

        sc.close();
    }

    // Helper function to get the next block in the sequence (B -> O -> J -> B ...)
    public static char getNextBlock(char current) {
        if (current == 'B') return 'O';
        if (current == 'O') return 'J';
        return 'B';
    }
}
