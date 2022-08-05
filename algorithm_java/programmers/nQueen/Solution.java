package programmers.nQueen;

public class Solution {
    private static final int MAX_N = 12;
    private static final boolean[] colVisit = new boolean[MAX_N];
    private static final boolean[] leftDiagVisit = new boolean[2 * MAX_N];
    private static final boolean[] rightDiagVisit = new boolean[2 * MAX_N];
    private static int answer, N;

    private static void visit(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int col = 0; col < N; col++) {
            int sum = row + col, diff = col - row + N;
            if (colVisit[col] || leftDiagVisit[sum] || rightDiagVisit[diff])
                continue;
            colVisit[col] = true;
            leftDiagVisit[sum] = true;
            rightDiagVisit[diff] = true;
            visit(row + 1);
            colVisit[col] = false;
            leftDiagVisit[sum] = false;
            rightDiagVisit[diff] = false;
        }
    }

    public static int solution(int n) {
        N = n;
        answer = 0;
        visit(0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5)); // 2
    }
}
