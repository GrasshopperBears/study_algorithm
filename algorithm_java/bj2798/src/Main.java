import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardNum = Integer.parseInt(st.nextToken());
        int theNumber = Integer.parseInt(st.nextToken());
        int i = 0, j = 1, k = 2, max = 0;
        int[] cards = new int[cardNum];

        st = new StringTokenizer(br.readLine());
        for (int l = 0; l < cardNum; l++) {
            cards[l] = Integer.parseInt(st.nextToken());
        }
        br.close();

        while (i <= cardNum - 3 && j <= cardNum - 2 && k <= cardNum - 1) {
            int selection = cards[i] + cards[j] + cards[k];
            if (selection <= theNumber && selection > max) {
                max = selection;
            }

            if (j == cardNum - 2 && k == cardNum - 1) {
                i++;
                j = i + 1;
                k = j + 1;
            } else if (k == cardNum - 1) {
                j++;
                k = j + 1;
            } else {
                k++;
            }
        }

        System.out.println(max);
    }
}
