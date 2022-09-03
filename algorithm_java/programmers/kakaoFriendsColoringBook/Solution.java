package programmers.kakaoFriendsColoringBook;

import java.util.*;

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private final int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private int m, n;
    private boolean[][] visited;
    private int[][] picture;

    private int bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        int area = 1, base = picture[r][c];
        q.add(new Point(r, c));
        visited[r][c] = true;

        while (q.size() > 0) {
            Point first = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = first.r + directions[i], nextC = first.c + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n)
                    continue;
                if (visited[nextR][nextC] || picture[nextR][nextC] != base)
                    continue;
                q.add(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
                area++;
            }
        }
        return area;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = 0;

        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];
        this.picture = picture;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    int area = bfs(i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
