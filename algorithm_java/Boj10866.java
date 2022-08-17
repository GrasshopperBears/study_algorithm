import java.io.BufferedReader;
import java.io.InputStreamReader;

// class Node {
//     int val;
//     Node next, prev;

//     public Node(int val) {
//         this.val = val;
//     }
// }

class Deque {
    int size = 0, front = 0, back = 0, capacity;
    int[] arr;

    public Deque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    private int increase(int num) {
        int result = num + 1;
        if (result >= capacity)
            result -= capacity;
        return result;
    }

    private int decrease(int num) {
        int result = num - 1;
        if (result < 0)
            result += capacity;
        return result;
    }

    public void pushFront(int num) {
        this.arr[this.front] = num;
        if (this.front == this.back)
            this.back = this.increase(this.back);
        this.front = this.decrease(this.front);
        this.size++;
    }

    public void pushBack(int num) {
        this.arr[this.back] = num;
        if (this.front == this.back)
            this.front = this.decrease(this.front);
        this.back = this.increase(this.back);
        this.size++;
    }

    public int popFront() {
        if (this.size == 0)
            return -1;
        this.size--;
        this.front = this.increase(this.front);
        return this.arr[this.front];
    }

    public int popBack() {
        if (this.size == 0)
            return -1;
        this.size--;
        this.back = this.decrease(this.back);
        return this.arr[this.back];
    }

    public int size() {
        return this.size;
    }

    public int empty() {
        return this.size == 0 ? 1 : 0;
    }

    public int front() {
        if (this.size == 0)
            return -1;
        return this.arr[increase(this.front)];
    }

    public int back() {
        if (this.size == 0)
            return -1;
        return this.arr[decrease(this.back)];
    }
}

public class Boj10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderCount = Integer.parseInt(br.readLine());
        Deque dq = new Deque(orderCount);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < orderCount; i++) {
            String[] tokens = br.readLine().split(" ");
            String order = tokens[0];

            if (order.equals("push_front")) {
                dq.pushFront(Integer.parseInt(tokens[1]));
            } else if (order.equals("push_back")) {
                dq.pushBack(Integer.parseInt(tokens[1]));
            } else if (order.equals("pop_front")) {
                answer.append(dq.popFront()).append("\n");
            } else if (order.equals("pop_back")) {
                answer.append(dq.popBack()).append("\n");
            } else if (order.equals("size")) {
                answer.append(dq.size()).append("\n");
            } else if (order.equals("empty")) {
                answer.append(dq.empty()).append("\n");
            } else if (order.equals("front")) {
                answer.append(dq.front()).append("\n");
            } else if (order.equals("back")) {
                answer.append(dq.back()).append("\n");
            }
        }
        System.out.println(answer.toString());
    }
}
