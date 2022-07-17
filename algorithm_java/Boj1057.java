import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int currentNumber = Integer.parseInt(line[0]);
        int kim = Integer.parseInt(line[1]);
        int lim = Integer.parseInt(line[2]);
        int round = 1;

        while(Math.abs(kim - lim) != 1 || Math.max(kim, lim) % 2 != 0){
            int isOdd = currentNumber % 2;
            if (kim == currentNumber) {
                kim = kim / 2 + isOdd;
                lim /= 2;
            } else if (lim == currentNumber) {
                kim /= 2;
                lim = lim / 2 + isOdd;
            } else {
                kim = kim / 2 + kim  % 2;
                lim = lim / 2 + lim % 2;
            }
            currentNumber = currentNumber / 2 + isOdd;
            round++;
        }
        System.out.println(round);
    }
}
