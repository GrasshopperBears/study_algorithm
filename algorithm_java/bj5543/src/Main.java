import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min_burger = 3000;
        int min_soda = 3000;

        min_burger = Math.min(min_burger, Integer.parseInt(br.readLine()));
        min_burger = Math.min(min_burger, Integer.parseInt(br.readLine()));
        min_burger = Math.min(min_burger, Integer.parseInt(br.readLine()));

        min_soda = Math.min(min_soda, Integer.parseInt(br.readLine()));
        min_soda = Math.min(min_soda, Integer.parseInt(br.readLine()));

        br.close();
        System.out.println(min_burger + min_soda - 50);
    }
}
