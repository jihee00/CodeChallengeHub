package week3.day3;

import java.util.Scanner;

public class Baekjoon6987 {
    static int[][] results;
    static boolean isPossible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        results = new int[6][3]; // 6 teams with 3 values each (wins, draws, losses)
        int[] answers = new int[4]; // To store the output for the 4 test cases

        for (int i = 0; i < 4 ; i++) {
            isPossible = false;

            for (int j = 0; j < 6; j++) {
                results[j][0] = sc.nextInt();
                results[j][1] = sc.nextInt();
                results[j][2] = sc.nextInt();
            }
            // Check if the result is possible for the current configuration
            if (checkPossibility(0,1)) {
                answers[i] = 1;
            } else {
                answers[i] = 0;
            }
        }

        for (int answer : answers) {
            System.out.print(answer + " ");
        }
        sc.close();
    }

    // Recursive function
    static boolean checkPossibility(int team1, int team2) {
        if (team1 == 5) {
            return isValid();
        }

        if (team2 == 6) {
            return checkPossibility(team1 + 1, team1 + 2); // Move to the next pair of teams
        }

        // Case 1: team1 wins, team2 loses
        if (results[team1][0] > 0 && results[team2][2] > 0) {
            results[team1][0]--;
            results[team2][2]--;
            if (checkPossibility(team1, team2 + 1)) return true;
            results[team1][0]++;
            results[team2][2]++;
        }

        // Case 2: team1 and team2 draw
        if (results[team1][1] > 0 && results[team2][1] > 0) {
            results[team1][1]--;
            results[team2][1]--;
            if (checkPossibility(team1, team2 + 1)) return true;
            results[team1][1]++;
            results[team2][1]++;
        }

        // Case 3: team1 loses, team2 wins
        if (results[team1][2] > 0 && results[team2][0] > 0) {
            results[team1][2]--;
            results[team2][0]--;
            if (checkPossibility(team1, team2 + 1)) return true;
            results[team1][2]++;
            results[team2][0]++;
        }
        return false;
    }

    // Function to check if all wins, draws, and losses are zero (meaning all results are valid)
    static boolean isValid() {
        for (int i = 0; i < 6; i++) {
            if (results[i][0] != 0 || results[i][1] != 0 || results[i][2] !=0 ) {
                return false;
            }
        }
        return true; // All teams have valid results
    }
}
