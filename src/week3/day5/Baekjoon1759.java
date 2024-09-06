package week3.day5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1759 {
    static int L, C;
    static char[] chars;
    static boolean[] visited;
    static char[] password;
    static final String VOWELS = "aeiou"; // String containing vowels for easy checking
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        chars = new char[C];
        password = new char[L];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            chars[i] = sc.next().charAt(0);
        }

        Arrays.sort(chars);
        generatePassword(0,0);
        System.out.print(sb.toString());
        sc.close();
    }

    static void generatePassword(int index, int start) {
        // Base case: If the password is of length L
        if (index == L) {
            if (isValid()) {
                sb.append(password).append('\n');
            }
            return;
        }
        // Iterate over the available characters
        for (int i = start; i < C; i++) {
            password[index] = chars[i];
            generatePassword(index + 1, i + 1);
        }
    }

    // Function to check if the password is valid (at least 1 vowel and 2 consonants)
    static boolean isValid() {
        int vowels = 0;
        int consonants  = 0;

        for (char c : password) {
            if (VOWELS.contains(Character.toString(c))) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return vowels >= 1 && consonants >= 2;
    }
}