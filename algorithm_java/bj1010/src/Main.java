import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < caseNumber; i++) {
            String[] bridgesString = br.readLine().trim().split(" ");
            int[] bridges = new int[2];
            for (int j = 0; j < 2; j++) {
                bridges[j] = Integer.parseInt(bridgesString[j]);
            }

            if (bridges[0] <= bridges[1] / 2) {
                System.out.println(combination(bridges[1], bridges[0]));
            } else {
                System.out.println(combination(bridges[1], bridges[1] - bridges[0]));
            }
        }
    }

    public static BigInteger combination(int n, int c){
        BigInteger answer = new BigInteger("1");
        for (int i = n; i > n - c; i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer.divide(BigInteger.valueOf(factorial(c)));
    }

    public static long factorial(int n){
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }
}
