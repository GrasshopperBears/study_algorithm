import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split(" ");
        int guitarStrings = Integer.parseInt(firstLine[0]);
        int caseNumber = Integer.parseInt(firstLine[1]);
        int minPackagePrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE;

        for (int i = 0; i < caseNumber; i++) {
            String[] eachCase = br.readLine().trim().split(" ");
            int packagePrice = Integer.parseInt(eachCase[0]);
            int singlePrice = Integer.parseInt(eachCase[1]);
            if (minPackagePrice > packagePrice) {
                minPackagePrice = packagePrice;
            }
            if (minSinglePrice > singlePrice) {
                minSinglePrice = singlePrice;
            }
        }

        if (minSinglePrice * 6 < minPackagePrice){
            System.out.println(minSinglePrice * guitarStrings);
        } else {
            int buyFit = minPackagePrice * (guitarStrings / 6) + minSinglePrice * (guitarStrings % 6);
            int buyOnlyPackage =  minPackagePrice * (guitarStrings / 6 + (guitarStrings % 6 == 0 ? 0 : 1));
            System.out.println(Math.min(buyFit, buyOnlyPackage));
        }
    }
}
