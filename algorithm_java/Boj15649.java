import java.io.*;
import java.util.Stack;

public class Boj15649 {
    private static int N;
    private static boolean[] visited = new boolean[9];
    private static StringBuilder answer;
    private static Stack<Integer> stack = new Stack<>();

    private static void add() {
        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i)).append(" ");
        }
        answer.append("\n");
    }

    private static void visit(int left) {
        if (left == 0) {
            add();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            stack.add(i);
            visit(left - 1);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int M = Integer.parseInt(tokens[1]);

        N = Integer.parseInt(tokens[0]);
        stack.clear();
        answer = new StringBuilder();

        visit(M);

        System.out.println(answer.toString());
    }
}
