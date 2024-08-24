package week1.day6;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9093 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++){
            String sentence = sc.nextLine();
            String[] words = sentence.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                Stack<Character> stack = new Stack<>();
                for (char c : word.toCharArray()) {
                    stack.push(c);
                }
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(" ");
            }
            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}
