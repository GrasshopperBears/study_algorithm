import java.io.*;
import java.util.Stack;

public class Boj15650 {
    private static StringBuilder answer;
    private static Stack<Integer> stack = new Stack<>();

    private static void add() {
        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i)).append(" ");
        }
        answer.append("\n");
    }

    private static void visit(int curr, int max, int left) {
        if (left == 0) {
            add();
            return;
        }
        stack.push(curr);
        visit(curr + 1, max, left - 1);
        stack.pop();
        if (curr + left - 1 < max)
            visit(curr + 1, max, left);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);

        stack.clear();
        answer = new StringBuilder();
        visit(1, N, M);

        System.out.println(answer.toString());
    }
}
