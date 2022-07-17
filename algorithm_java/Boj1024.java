import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1024 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int targetSum = Integer.parseInt(input[0]);
        int minimumNumber = Integer.parseInt(input[1]);
        int curruntNumber = minimumNumber;

        String answer = "";
        while (curruntNumber <= 100){
            if (curruntNumber % 2 == 1 && targetSum % curruntNumber == 0){
                int mid = targetSum / curruntNumber;
                if (mid - curruntNumber / 2 < 0) {
                    curruntNumber++;
                    continue;
                }

                answer += mid;
                for (int i = 1; i <= curruntNumber / 2; i++) {
                    answer = (mid - i) + " " + answer + " " + (mid + i);
                }
                break;
            } else if (curruntNumber % 2 == 0 && targetSum % (curruntNumber / 2) == 0 && (targetSum / (curruntNumber / 2)) % 2 != 0) {
                int midsSum = targetSum / (curruntNumber / 2);
                int midLeft = midsSum / 2;
                int midRight = midsSum / 2 + 1;
                if (midRight - curruntNumber / 2< 0) {
                    curruntNumber++;
                    continue;
                }

                answer = midLeft + " " + midRight;
                for (int i = 1; i < curruntNumber / 2; i++) {
                    answer = (midLeft - i) + " " + answer + " " + (midRight + i);
                }
                break;
            }
            curruntNumber++;
        }
        if (answer.length() == 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
