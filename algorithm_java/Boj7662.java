import java.io.BufferedReader;
import java.io.InputStreamReader;

class HeapNode {
    boolean deleted = false;
    int val;

    public HeapNode(int val) {
        this.val = val;
    }
}

class Heap {
    int size = 0;
    boolean isMinHeap;
    HeapNode[] heap = new HeapNode[1000001];

    public Heap(boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
    }

    public void clear() {
        this.size = 0;
    }

    public void push(HeapNode node) {
        heap[++size] = node;
        for (int i = size; i > 1;) {
            int parent = i >> 1;
            if ((isMinHeap && heap[parent].val > heap[i].val)
                    || (!isMinHeap && heap[parent].val < heap[i].val)) {
                HeapNode tmp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = tmp;
            } else {
                return;
            }
            i = parent;
        }
    }

    public void pushDown(int idx) {
        int left = idx << 1;
        if (left > size)
            return;
        int targetChild = (left == size)
                || (isMinHeap && heap[left].val < heap[left + 1].val)
                || (!isMinHeap && heap[left].val > heap[left + 1].val)
                        ? left
                        : left + 1;
        if ((isMinHeap && heap[idx].val <= heap[targetChild].val)
                || (!isMinHeap && heap[idx].val >= heap[targetChild].val))
            return;
        HeapNode tmp = heap[idx];
        heap[idx] = heap[targetChild];
        heap[targetChild] = tmp;
        pushDown(targetChild);
    }

    public HeapNode pop(boolean remove) {
        while (size > 0) {
            HeapNode first = heap[1], last = heap[size--];

            if (size > 0) {
                heap[1] = last;
                pushDown(1);
            }

            if (!first.deleted) {
                if (remove)
                    first.deleted = true;
                return first;
            }
        }
        return null;
    }
}

public class Boj7662 {
    private static Heap maxHeap = new Heap(false);
    private static Heap minHeap = new Heap(true);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int ops = Integer.parseInt(br.readLine());
            minHeap.clear();
            maxHeap.clear();

            for (int op = 0; op < ops; op++) {
                String[] tokens = br.readLine().split(" ");
                int num = Integer.parseInt(tokens[1]);

                if (tokens[0].charAt(0) == 'I') {
                    HeapNode node = new HeapNode(num);
                    minHeap.push(node);
                    maxHeap.push(node);
                } else if (num == 1) {
                    maxHeap.pop(true);
                } else {
                    minHeap.pop(true);
                }
            }
            HeapNode smallest = minHeap.pop(false), largest = maxHeap.pop(false);
            if (smallest == null)
                System.out.println("EMPTY");
            else
                System.out.printf("%d %d\n", largest.val, smallest.val);
        }
    }
}
