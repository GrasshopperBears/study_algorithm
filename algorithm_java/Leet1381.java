class Slot {
    int val, inc;

    public Slot(int val) {
        this.val = val;
        this.inc = 0;
    }
}

class CustomStack {
    Slot[] stack;
    int size, currInc;

    public CustomStack(int maxSize) {
        stack = new Slot[maxSize];
        size = 0;
        currInc = 0;
    }
    
    public void push(int x) {
        if (size == stack.length) return;
        if (size > 0) stack[size-1].inc += currInc;
        stack[size++] = new Slot(x);
        currInc = 0;
    }
    
    public int pop() {
        if (size == 0) return -1;
        Slot last = stack[--size];
        currInc += last.inc;
        return last.val + currInc;
    }
    
    public void increment(int k, int val) {
        if (k == 0 || size == 0) return;
        stack[Math.min(k-1, size-1)].inc += val;
    }
}