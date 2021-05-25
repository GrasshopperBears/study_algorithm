import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().trim().split(" ");
        int wordNumber = Integer.parseInt(condition[0]);
        int charNumber = Integer.parseInt(condition[1]) - 5;
        String characters = "";
        String defaultCharacters = "antic";
        int maxWords = 0;
        String[] input = new String[wordNumber];
        int[] binaryBits = new int[wordNumber];


        if (charNumber < 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < wordNumber; i++) {
            String line = br.readLine().trim();
            for (int j = 4; j < line.length() - 4; j++) {
                char curr = line.charAt(j);
                if (defaultCharacters.indexOf(curr) == -1 && characters.indexOf(curr) == -1){
                    characters += curr;
                }
            }
            input[i] = line.substring(4, line.length() - 4);
        }

        for (int i = 0; i < wordNumber; i++) {
            String line = input[i];
            if(line.length() == 0){
                binaryBits[i] = -1;
                continue;
            }

            String[] bitMask = new String[characters.length()];
            Arrays.fill(bitMask, "0");

            int diffCount = 0;
            for (int j = 0; j < line.length(); j++) {
                int curr = characters.indexOf(line.charAt(j));
                if (curr != -1){
                    diffCount++;
                    bitMask[curr] = "1";
                }
            }
            if (diffCount > wordNumber){
                binaryBits[i] = -1;
            } else {
                binaryBits[i] = Integer.parseInt(String.join("", bitMask) ,2);
            }
        }

        System.out.println(binaryBits);
    }

    public static int[] bitMaskGenerator(int len, int num) {
        int[] bitMask = new int[combination(len, num).intValue()];
        for (int i = 0; i < bitMask.length; i++) {

        }

        return bitMask;
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
