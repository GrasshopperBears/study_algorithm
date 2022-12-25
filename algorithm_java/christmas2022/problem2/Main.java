package christmas2022.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, minDist = Integer.MAX_VALUE;
        int cityCount = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] positions = new int[cityCount];

        for (int i = 0; i < cityCount; i++) {
            positions[i] = Integer.parseInt(tokens[i]);
        }

        for (int i = 0; i < cityCount - 1; i++) {
            int dist = positions[i+1] - positions[i];
            if (dist < minDist) {
                count = 1;
                minDist = dist;
            } else if (dist == minDist) {
                count++;
            }
        }

        System.out.println(count);
    }
}

