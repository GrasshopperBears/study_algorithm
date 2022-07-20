import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2108 {
    public static int updateFrequency(ArrayList<Integer> freq, int freqCnt, int curr, int currCnt) {
        if (freqCnt < currCnt) {
            freq.clear();
            freq.add(curr);
            return currCnt;
        } 
        if (freqCnt == currCnt) freq.add(curr);
        return freqCnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), num, freqCnt = 0, curr = 4001, currCnt = -1;
        double sum = 0;
        ArrayList<Integer> nums = new ArrayList<>(N), freq = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);
        
        Iterator<Integer> itr = nums.iterator();
        while (itr.hasNext()) {
            num = itr.next();
            sum += num;

            if (num != curr) {
                freqCnt = updateFrequency(freq, freqCnt, curr, currCnt);
                curr = num;
                currCnt = 1;
            } else {
                currCnt++;
            }
        }
        updateFrequency(freq, freqCnt, curr, currCnt);
        Collections.sort(freq);

        System.out.println(Math.round(sum / N));
        System.out.println(nums.get(N / 2));
        System.out.println(freq.size() > 1 ? freq.get(1) : freq.get(0));
        System.out.println(nums.get(N-1) - nums.get(0));
    }
}
