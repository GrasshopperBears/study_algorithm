import java.io.BufferedReader;
import java.io.InputStreamReader;

class HeapNode1 {
    int key, val;

    public HeapNode1(int val) {
        this.key = Math.abs(val);
        this.val = val;
    }

    public boolean isPriorTo(HeapNode1 heapNode) {
        if (this.key < heapNode.key)
            return true;
        if (this.key > heapNode.key)
            return false;
        return this.val <= heapNode.val;
    }
}

public class Boj11286 {
    private static int size = 0;
    private static HeapNode1[] heap;

    private static void push(HeapNode1 heapNode) {
        heap[++size] = heapNode;
        for (int i = size; i > 1;) {
            int parent = i >> 1;
            if (heap[parent].isPriorTo(heapNode))
                return;
            heap[i] = heap[parent];
            heap[parent] = heapNode;
            i = parent;
        }
    }

    private static int pop() {
        if (size == 0)
            return 0;
        HeapNode1 first = heap[1];
        heap[1] = heap[size--];

        for (int i = 1; (i << 1) <= size;) {
            int left = i << 1;
            int target = left == size || heap[left].isPriorTo(heap[left + 1]) ? left : left + 1;
            if (heap[i].isPriorTo(heap[target]))
                break;
            HeapNode1 tmp = heap[i];
            heap[i] = heap[target];
            heap[target] = tmp;
            i = target;
        }
        return first.val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        heap = new HeapNode1[n + 1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                answer.append(pop()).append('\n');
            else
                push(new HeapNode1(num));
        }
        System.out.println(answer.toString());
    }
}
