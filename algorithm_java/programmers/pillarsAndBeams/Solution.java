package programmers.pillarsAndBeams;

class Point {
    boolean pillar = false, beam = false;
}

class Solution {
    public static int[][] solution(int n, int[][] build_frame) {
        int constructCount = 0;
        Point[][] grid = new Point[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                grid[i][j] = new Point();
        }

        for (int[] build : build_frame) {
            int c = build[0], r = n - build[1];
            boolean isPillar = build[2] == 0, isDelete = build[3] == 0;
            if (r < 0 || c < 0 || r > n || c > n || (isPillar && r == 0) || (!isPillar && (r == n || c == n)))
                continue;
            if (!isDelete) {
                if (isPillar) {
                    if (r == n || grid[r + 1][c].pillar || grid[r][c].beam || (c > 0 && grid[r][c - 1].beam)) {
                        grid[r][c].pillar = true;
                        constructCount++;
                    }
                } else {
                    if (grid[r + 1][c].pillar || grid[r + 1][c + 1].pillar
                            || (c > 0 && grid[r][c - 1].beam && grid[r][c + 1].beam)) {
                        grid[r][c].beam = true;
                        constructCount++;
                    }
                }
            } else {
                if (isPillar) {
                    if (grid[r - 1][c].pillar) {
                        if (c == 0) {
                            if (!grid[r - 1][c].beam)
                                continue;
                        } else if (!grid[r - 1][c].beam && !grid[r - 1][c - 1].beam)
                            continue;
                    }
                    if (c > 0 && (grid[r - 1][c - 1].beam != grid[r - 1][c].beam))
                        continue;
                    grid[r][c].pillar = false;
                    constructCount--;
                } else {
                    if (grid[r][c].pillar && !grid[r + 1][c].pillar) {
                        if (c == 0) {
                            if (!grid[r][c].beam)
                                continue;
                        } else if (!grid[r][c - 1].beam && !grid[r][c].beam)
                            continue;
                    }
                    if (grid[r][c + 1].pillar && !grid[r + 1][c + 1].pillar) {
                        if (c == n - 1) {
                            if (!grid[r][c].beam)
                                continue;
                        } else if (!grid[r][c].beam && !grid[r][c + 1].beam)
                            continue;
                    }
                    if (c > 0 && grid[r][c - 1].beam && grid[r][c + 1].beam)
                        continue;
                    grid[r][c].beam = false;
                    constructCount--;
                }
            }
        }

        int[][] answer = new int[constructCount][3];
        int idx = 0;
        for (int x = 0; x <= n; x++) {
            for (int i = n; i >= 0; i--) {
                int y = n - i;
                if (grid[i][x].pillar) {
                    answer[idx][0] = x;
                    answer[idx][1] = y;
                    answer[idx++][2] = 0;
                }
                if (grid[i][x].beam) {
                    answer[idx][0] = x;
                    answer[idx][1] = y;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 },
                { 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } }));
        System.out.println(solution(5, new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 },
                { 1, 1, 1, 1 }, { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } }));
    }
}
