package christmas2022.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseNumber = Integer.parseInt(br.readLine());
        int[] radiuses = new int[101];
        String[] tokens = br.readLine().split(" ");
        int maxHouses = 0;

        for (int i = 0; i < houseNumber; i++) {
            int radius = Integer.parseInt(tokens[i]);
            radiuses[radius]++;
        }

        for (int i = 2; i <= 100; i++) {
            int currentRadius = i, currentCounts = 0;
            while (currentRadius <= 100) {
                currentCounts += radiuses[currentRadius];
                currentRadius += i;
            }
            if (currentCounts > maxHouses) {
                maxHouses = currentCounts;
            }
        }
        System.out.println(maxHouses);
    }
}

