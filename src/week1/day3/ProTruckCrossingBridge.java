package week1.day3;

import java.util.LinkedList;
import java.util.Queue;

public class ProTruckCrossingBridge {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // Elapsed time
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0;
        int index = 0; // Index of the next truck to get on the bridge

        // Initialize the queue with zeros representing the empty spaces on the bridge
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            // Remove the truck (or empty space) at the front of the bridge
            totalWeight -= bridge.poll();

            if (totalWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                totalWeight += truck_weights[index];
                index++;
            } else {
                bridge.add(0);
            }
            answer++;
        }

        // Add the time it takes for the last truck to completely cross the bridge
        answer += bridge_length;

        return answer;
    }
}
