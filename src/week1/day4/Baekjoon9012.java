package week1.day4;


import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String ps = sc.nextLine();
            System.out.println(isVPS(ps) ? "YES" : "NO");
        }

        sc.close();
    }

    public static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
