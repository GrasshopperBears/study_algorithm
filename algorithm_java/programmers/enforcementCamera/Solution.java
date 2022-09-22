package programmers.enforcementCamera;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0, curr = 0;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);

        while (curr < routes.length) {
            int camPos = routes[curr][1], next = curr + 1;
            answer++;
            while (next < routes.length) {
                if (routes[next][0] > camPos)
                    break;
                if (routes[next][1] < camPos)
                    camPos = routes[next][1];
                next++;
            }
            curr = next;
        }
        return answer;
    }
}

/*
 * Test cases
 * 
 * print([[-20,15],[-14, -5],[-18, -13],[-5, -3]], 2);
 * print([[-2, -1],[1, 2],[-3, 0]], 2);
 * print([[0, 0]], 1);
 * print([[0, 1],[0, 1],[1, 2]], 1);
 * print([[0, 1],[2, 3],[4, 5],[6, 7]], 4);
 * print([[-20, 15],[-14, -5],[-18, -13],[-5, -3]], 2);
 * print([[-20, 15],[-20, -15],[-14, -5],[-18, -13],[-5, -3]], 2)
 */
