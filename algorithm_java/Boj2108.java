import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        double sum = 0;

        for (int i = 0; i < caseNum; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            if (sortedMap.containsKey(num)) {
                sortedMap.put(num, sortedMap.get(num) + 1);
            } else {
                sortedMap.put(num, 1);
            }
        }

        int max_freq = 0, middle = 0, pos = -1, middlePos = (caseNum - 1) / 2;
        ArrayList<Integer> max_freq_values = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set = sortedMap.entrySet();

        for (Map.Entry<Integer, Integer>tmpEntry: set) {
            int key = tmpEntry.getKey();
            int val = tmpEntry.getValue();
            pos += val;

            if (middle == 0 && pos >= middlePos) {
                middle = key;
            }

            if (val > max_freq) {
                max_freq_values.clear();
                max_freq_values.add(key);
                max_freq = val;
            } else if (val == max_freq) {
                max_freq_values.add(key);
            }
        }

        System.out.println(Math.round(sum / caseNum));
        System.out.println(middle);

        if (max_freq_values.size() == 1) {
            System.out.println(max_freq_values.get(0));
        } else {
            max_freq_values.sort((o1, o2) -> o1 - o2);
            System.out.println(max_freq_values.get(1));
        }

        System.out.println(sortedMap.lastKey() - sortedMap.firstKey());
    }
}
