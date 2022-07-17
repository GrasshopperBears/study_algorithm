import java.util.Scanner;

public class Boj2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();

        ip = ip.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "a");

        System.out.println(ip.length());
    }
}
