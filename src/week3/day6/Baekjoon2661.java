package week3.day6;

import java.util.Scanner;

public class Baekjoon2661 {
    static int N; // Length of the sequence
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        generateSequence("");
        sc.close();
    }

    static void generateSequence(String seq) {
        if (found) return; // If a valid sequence is already found, terminate recursion

        // Base case: If the sequence reaches length N, print it and terminate
        if (seq.length() == N) {
            System.out.println(seq);
            found = true;
            return;
        }

        // Try adding 1, 2, or 3 to the current sequence and recurse
        for (int i = 1; i <= 3; i++) {
            if (isGood(seq + i)) {
                generateSequence(seq+i); // Recur with the new sequence
            }
        }
    }

    // Function to check if the current sequence is a good sequence
    static boolean isGood(String seq) {
        int len = seq.length();

        for (int size = 1; size <= len/2; size++) {
            String part1 = seq.substring(len - size - size, len - size);
            String part2 = seq.substring(len - size, len);

            if (part1.equals(part2)) {
                return false;
            }
        }
        return true;
    }
}
