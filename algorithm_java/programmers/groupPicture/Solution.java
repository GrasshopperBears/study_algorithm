package programmers.groupPicture;

class Info {
    int a, b, minDist, maxDist;

    public Info(int a, int b, int minDist, int maxDist) {
        this.a = a;
        this.b = b;
        this.minDist = minDist;
        this.maxDist = maxDist;
    }
}

public class Solution {
    private static int answer = 0;
    private static Info[] infos;
    private static int[] positions = new int[8];
    private static boolean[] visited = new boolean[8];

    private static boolean check() {
        for (Info info : infos) {
            int dist = Math.abs(positions[info.a] - positions[info.b]) - 1;
            if (dist >= info.maxDist || dist <= info.minDist)
                return false;
        }
        return true;
    }

    private static void checkPermutation(int depth) {
        if (depth == 8) {
            if (check())
                answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                positions[depth] = i;
                checkPermutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int charToIdx(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'F':
                return 2;
            case 'J':
                return 3;
            case 'M':
                return 4;
            case 'N':
                return 5;
            case 'R':
                return 6;
            case 'T':
            default:
                return 7;
        }
    }

    public static int solution(int n, String[] data) {
        infos = new Info[n];

        for (int i = 0; i < n; i++) {
            String s = data[i];
            int x = charToIdx(s.charAt(0)), y = charToIdx(s.charAt(2)), d = s.charAt(4) - '0';
            char cmp = s.charAt(3);

            if (cmp == '<') {
                infos[i] = new Info(x, y, -1, d);
            } else if (cmp == '>') {
                infos[i] = new Info(x, y, d, 8);
            } else {
                infos[i] = new Info(x, y, d - 1, d + 1);
            }
        }
        checkPermutation(0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, new String[] { "N~F=0", "R~T>2" }));
    }
}
