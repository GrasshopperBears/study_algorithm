import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int coinNum = Integer.parseInt(line[0]);
        int[] coinList = new int[coinNum];
        int[] possibleCases = new int[Integer.parseInt(line[1]) + 1];

        for (int i = 0; i < coinNum; i++) {
            coinList[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(coinList);

        for (int i = 0; i < coinNum; i++) {
            
        }

        for (int i = 0; i < possibleCases.length; i++) {

        }
    }
}
