import java.util.Arrays;
import java.util.PriorityQueue;
import leetLibrary.Utils;

class Info implements Comparable<Info> {
    int num, freq;
    public Info(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Info info) {
        if (this.freq != info.freq) return this.freq - info.freq > 0 ? -1 : 1;
        return this.num - info.num > 0 ? 1 : -1;
    }
}

class Leet347 {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Info> heap = new PriorityQueue<>();
        int[] answer = new int[k];
        Arrays.sort(nums);
        int curr = nums[0], cts = 1, num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (curr == num) cts++;
            else {
                heap.add(new Info(curr, cts));
                curr = num;
                cts = 1;
            }
        }
        heap.add(new Info(curr, cts));
        for (int i = 0; i < k; i++) {
            answer[i] = heap.poll().num;
        }
        return answer;
    }

    public static void main(String[] args) {
        Utils.printArray(topKFrequent(new int[] {1,1,1,2,2,3}, 2)); // [1, 2]
        Utils.printArray(topKFrequent(new int[] {1}, 1)); // [1]
        Utils.printArray(topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2)); // [-1, 2]
    }
}
