import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11279 {
    private static int size = 0;
    private static final int[] heap = new int[100000];

    private static void insert(int num) {
        heap[++size] = num;
        for (int i = size; i > 1; i /= 2) {
            int parent = i >> 1;
            if (heap[parent] >= heap[i])
                break;
            int tmp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = tmp;
        }
    }

    private static int pop() {
        if (size == 0)
            return 0;
        int min = heap[1], current = 1;
        heap[1] = heap[size];
        heap[size--] = 0;
        while (true) {
            int left = (current << 1), right = left + 1;
            if (left > size)
                break;
            int maxChild = heap[right] == 0 || heap[left] > heap[right] ? left : right;
            if (heap[maxChild] <= heap[current])
                break;
            int tmp = heap[current];
            heap[current] = heap[maxChild];
            heap[maxChild] = tmp;
            current = maxChild;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int op = 0; op < n; op++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                answer.append(pop()).append("\n");
            else
                insert(num);
        }
        System.out.println(answer.toString());
    }
}
