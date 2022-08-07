package programmers.pedestrianParadise;

class Node {
    private static final int MOD = 20170805;
    int fromTop = 0, fromLeft = 0;

    public int getTotal() {
        return (this.fromLeft + this.fromTop) % MOD;
    }
}

public class Solution {
    /**
     * 
     * @param m:       행
     * @param n:       열
     * @param cityMap: 0=자유 통행, 1=통행 금지, 2=직진만 가능
     * @return: 통행 가능 가짓수
     */
    public static int solution(int m, int n, int[][] cityMap) {
        Node[][] counts = new Node[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                counts[i][j] = new Node();
            }
        }
        counts[0][1].fromLeft++;
        counts[1][0].fromTop++;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j <= 1)
                    continue;
                // left
                if (j > 0) {
                    int leftTraffic = cityMap[i][j - 1];
                    if (leftTraffic == 0) {
                        counts[i][j].fromLeft = counts[i][j - 1].getTotal();
                    } else if (leftTraffic == 2) {
                        counts[i][j].fromLeft = counts[i][j - 1].fromLeft;
                    }
                }
                // top
                if (i > 0) {
                    int topTraffic = cityMap[i - 1][j];
                    if (topTraffic == 0) {
                        counts[i][j].fromTop = counts[i - 1][j].getTotal();
                    } else if (topTraffic == 2) {
                        counts[i][j].fromTop = counts[i - 1][j].fromTop;
                    }
                }
            }
        }
        return counts[m - 1][n - 1].getTotal();
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 3, new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } })); // 6
        System.out.println(
                solution(3, 6, new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } })); // 2
    }
}
