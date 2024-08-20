import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon1158 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            list.add(i);
        }

        StringBuilder output = new StringBuilder();
        output.append("<");

        int index = 0;

        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            output.append(list.remove(index));
            if (!list.isEmpty()) {
                output.append(", ");
            }
        }

        output.append(">");
        System.out.println(output);

        sc.close();
    }
}
