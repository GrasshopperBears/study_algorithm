import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Doc {
    int index, priority;

    public Doc(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Boj1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            String[] tokens = br.readLine().split(" ");
            int documents = Integer.parseInt(tokens[0]), target = Integer.parseInt(tokens[1]), maxPriority = 1;
            int order = 1;
            int[] priorityCounts = new int[10];
            Queue<Doc> q = new LinkedList<>();

            tokens = br.readLine().split(" ");
            for (int i = 0; i < documents; i++) {
                int priority = Integer.parseInt(tokens[i]);
                q.add(new Doc(i, priority));
                priorityCounts[priority]++;
                maxPriority = Math.max(maxPriority, priority);
            }

            while (true) {
                Doc head = q.poll();
                if (head.index == target && head.priority == maxPriority)
                    break;
                if (head.priority != maxPriority) {
                    q.add(head);
                } else {
                    if (--priorityCounts[maxPriority] == 0) {
                        while (priorityCounts[--maxPriority] == 0) {
                        }
                    }
                    order++;
                }
            }
            answer.append(order).append("\n");
        }
        System.out.println(answer.toString());
    }
}
