class CombinationIterator {
    String s;
    int len;
    int[] indices;
    boolean hasNext = true;

    public CombinationIterator(String characters, int combinationLength) {
        this.s = characters;
        this.len = combinationLength;
        indices = new int[this.len];
        for (int i = 0; i < indices.length; i++)
            indices[i] = i;
    }

    private void increaseIndex(int idx) {
        if (indices[idx] + len - idx < s.length()) {
            indices[idx]++;
        } else if (idx == 0) {
            this.hasNext = false;
        } else {
            increaseIndex(idx - 1);
            indices[idx] = indices[idx - 1] + 1;
        }
    }

    public String next() {
        StringBuilder result = new StringBuilder();
        for (int i : indices)
            result.append(s.charAt(i));
        increaseIndex(this.len - 1);
        return result.toString();
    }

    public boolean hasNext() {
        return this.hasNext;
    }
}

public class Leet1286 {
    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abc", 2);

        System.out.println(obj.next()); // "ab"
        System.out.println(obj.hasNext()); // true
        System.out.println(obj.next()); // "ac"
        System.out.println(obj.hasNext()); // true
        System.out.println(obj.next()); // "bc"
        System.out.println(obj.hasNext()); // false
    }
}
