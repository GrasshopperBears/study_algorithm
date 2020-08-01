import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().trim().split(" ");
        int caseNum = Integer.parseInt(tmp[0]);
        ArrayList<Integer> coins = new ArrayList<>();
        int total = Integer.parseInt(tmp[1]);
        int coinNum = 0;

        for (int i = 0; i < caseNum; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= total) {
                coins.add(coin);
            }
        }
        br.close();

        int idx = coins.size() - 1;
        while (total > 0) {
            int currMax = coins.get(idx);
            if (currMax <= total) {
                coinNum += (total / currMax);
                total -= (currMax * (total / currMax));
            }
            idx--;
        }

        System.out.println(coinNum);
    }
}
