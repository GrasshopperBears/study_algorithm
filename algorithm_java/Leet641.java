class MyCircularDeque {
    int size = 0, front = 0, back = 0, maxSize;
    int[] deque;

    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.deque = new int[k];
    }

    private int toRight(int idx) {
        return (idx + 1) % this.maxSize;
    }

    private int toLeft(int idx) {
        return idx == 0 ? this.maxSize - 1 : idx - 1;
    }

    public boolean insertFront(int value) {
        if (this.isFull())
            return false;

        this.size++;
        this.deque[this.front] = value;
        this.front = toLeft(this.front);
        if (this.size == 1)
            this.back = toRight(this.back);

        return true;
    }

    public boolean insertLast(int value) {
        if (this.isFull())
            return false;

        this.size++;
        this.deque[this.back] = value;
        this.back = toRight(this.back);
        if (this.size == 1)
            this.front = toLeft(this.front);

        return true;
    }

    public boolean deleteFront() {
        if (this.isEmpty())
            return false;

        this.size--;
        this.front = this.toRight(this.front);
        if (this.size == 0)
            this.back = this.toLeft(this.back);

        return true;
    }

    public boolean deleteLast() {
        if (this.isEmpty())
            return false;

        this.size--;
        this.back = this.toLeft(this.back);
        if (this.size == 0)
            this.front = this.toRight(this.front);

        return true;
    }

    public int getFront() {
        if (this.isEmpty())
            return -1;

        return this.deque[this.toRight(this.front)];
    }

    public int getRear() {
        if (this.isEmpty())
            return -1;

        return this.deque[this.toLeft(this.back)];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }
}

public class Leet641 {
    private static void tc1() {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1)); // return True
        System.out.println(myCircularDeque.insertLast(2)); // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear()); // return 2
        System.out.println(myCircularDeque.isFull()); // return True
        System.out.println(myCircularDeque.deleteLast()); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront()); // return 4
    }

    private static void tc2() {
        MyCircularDeque myCircularDeque = new MyCircularDeque(2);
        System.out.println(myCircularDeque.insertFront(7));
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertLast(5));
        System.out.println(myCircularDeque.insertFront(0));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.insertLast(0));
        // [null,true,true,-1,true,true,0,5,0,0,5,false]
    }

    public static void main(String[] args) {
        tc2();
    }
}
