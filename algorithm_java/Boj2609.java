import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Boj2609 {
    private static boolean isPrime(int num) {
        int bound = (int)Math.sqrt(num);
        for (int i = 2; i <= bound; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static HashMap<Integer, Integer> getFactors(int num, HashSet<Integer> keys) {
        int curr = num, factor = 2, exponent;
        HashMap<Integer, Integer> factors = new HashMap<>();
        while (curr > 1) {
            if (isPrime(factor) && curr % factor == 0) {
                exponent = 0;
                while (curr % factor == 0) {
                    exponent++;
                    curr /= factor;
                }
                factors.put(factor, exponent);
                keys.add(factor);
            }
            factor++;
        }
        return factors;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int lcm = 1, gcd = 1, key, val, exponent;
        HashSet<Integer> keys = new HashSet<>();
        HashMap<Integer, Integer> factors1 = getFactors(Integer.parseInt(tokens[0]), keys);
        HashMap<Integer, Integer> factors2 = getFactors(Integer.parseInt(tokens[1]), keys);

        for (HashMap.Entry<Integer, Integer> elem : factors1.entrySet() ){
            key = elem.getKey();
            val = elem.getValue();
            if (factors2.containsKey(key)) {
                gcd *= Math.pow(key, Math.min(val, factors2.get(key)));
            }
        }

        for (int primeKey: keys) {
            if (factors1.containsKey(primeKey)) {
                exponent = factors1.get(primeKey);
                if (factors2.containsKey(primeKey)) {
                    exponent = Math.max(exponent, factors2.get(primeKey));
                }
            } else {
                exponent = factors2.get(primeKey);
            }
            lcm *= Math.pow(primeKey, exponent);
        }
        System.out.printf("%d\n%d", gcd, lcm);
    }
}
