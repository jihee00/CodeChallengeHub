package week1.day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1966 {

    static class Document {
        int index;
        int priority;

        // Class to represent each document with its index and priority
        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int N = sc.nextInt(); //Number of documents
            int M = sc.nextInt(); //Position of the document of interest

            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[10];  // Array to count the number of documents for each priority (1-9)

            for (int j = 0; j < N; j++) {
                int priority = sc.nextInt();
                queue.offer(new Document(j, priority));
                priorities[priority]++;
            }

            int printOrder = 0; // To keep track of the print order

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // Check if there is any document with higher priority
                boolean hasHigherPriority = false;
                for (int p = current.priority + 1; p <= 9; p++) {
                    if (priorities[p] > 0) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.offer(current);  // If there is a higher priority document, send current document to the back
                } else {
                    printOrder++;
                    priorities[current.priority]--;  // Decrease the count of documents with this priority

                    if (current.index == M) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
