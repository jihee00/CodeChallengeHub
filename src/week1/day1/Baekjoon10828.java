package week1.day1;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();

        for (int i = 0; i < N ; i++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    int val = sc.nextInt();
                    stack.push(val);
                    break;

                case "pop":
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "top":
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}
