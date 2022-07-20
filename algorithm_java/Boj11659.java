import java.util.Scanner;

public class Boj11659 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        int N = sc.nextInt(), M = sc.nextInt(), from, to;
        int[] prefixSum = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            answer.append(prefixSum[to] - prefixSum[from-1]);
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}
