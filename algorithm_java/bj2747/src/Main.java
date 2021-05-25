import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num =  Integer.parseInt(br.readLine().trim());

        int first = 0;
        int second = 1;

        if (num == 0){
            System.out.println(first);
            return;
        } else if (num == 1){
            System.out.println(second);
            return;
        }

        int answer = 0;
        for (int i = 1; i < num; i++) {
            answer = first + second;
            first = second;
            second = answer;
        }

        System.out.println(answer);
    }
}
