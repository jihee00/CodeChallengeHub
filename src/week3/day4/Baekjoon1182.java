package week3.day4;

import java.util.Scanner;

public class Baekjoon1182 {
    static int N,S;
    static int[] numbers;
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        subsequence(0, 0, false);
        System.out.println(count);
        sc.close();
    }

    static void subsequence(int index, int currentSum, boolean chosen) {
        // Base case: if we have checked all elements
        if (index == N) {
            if (chosen && currentSum == S) {
                count++; // Only count if at least one element is chosen
            }
            return;
        }
        // Include the current element in the subsequence
        subsequence(index + 1, currentSum + numbers[index], true);
        // Exclude the current element from the subsequence
        subsequence(index + 1, currentSum, chosen);
    }
}
