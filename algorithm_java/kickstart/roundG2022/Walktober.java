package kickstart.roundG2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Walktober {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            int diff = 0;
            String[] tokens = br.readLine().split(" ");
            int p = Integer.parseInt(tokens[0]), days = Integer.parseInt(tokens[1]), john = Integer.parseInt(tokens[2]);
            int[] lastYearWalk = new int[days];
            int[] maxRecords = new int[days];

            for (int i = 1; i <= p; i++) {
                tokens = br.readLine().split(" ");
                if (i == john) {
                    for (int j = 0; j < days; j++)
                        lastYearWalk[j] = Integer.parseInt(tokens[j]);
                } else {
                    for (int j = 0; j < days; j++)
                        maxRecords[j] = Math.max(maxRecords[j], Integer.parseInt(tokens[j]));
                }
            }

            for (int i = 0; i < days; i++)
                diff += Math.max(0, maxRecords[i] - lastYearWalk[i]);

            answer.append("Case #").append(t).append(": ").append(diff).append('\n');
        }

        System.out.println(answer.toString());
    }
}
