import java.util.*;

public class Leet869 {
    private int getDigits(int n) {
        int digits = 0;
        while (n > 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }

    private HashMap<Integer, Integer> getDigitsMap(int n) {
        HashMap<Integer, Integer> result = new HashMap<>();

        while (n > 0) {
            int last = n % 10;
            result.put(last, result.getOrDefault(last, 0) + 1);
            n /= 10;
        }

        return result;
    }

    public boolean reorderedPowerOf2(int n) {
        int min = (int) Math.pow(10, getDigits(n) - 1), max = min * 10, base = 1;
        ArrayList<HashMap<Integer, Integer>> digitsSetList = new ArrayList<>();
        HashMap<Integer, Integer> inputDigitsSet = getDigitsMap(n);

        while (base < min)
            base <<= 1;

        while (base < max && base > 0) {
            digitsSetList.add(getDigitsMap(base));
            base <<= 1;
        }

        for (HashMap<Integer, Integer> digitsSet : digitsSetList)
            if (digitsSet.equals(inputDigitsSet))
                return true;

        return false;
    }
}
