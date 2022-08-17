import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++)
            dq.add(i);
        boolean isThrow = true;
        while (dq.size() > 1) {
            int top = dq.removeFirst();
            if (!isThrow)
                dq.add(top);
            isThrow = !isThrow;
        }
        System.out.println(dq.pop());
    }
}
