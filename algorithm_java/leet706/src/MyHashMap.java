import java.util.*;

class MyHashMap {
    static int bucketSize = 32;
    LinkedList<Integer[]>[] hashMap;

    public MyHashMap() {
        hashMap = new LinkedList[bucketSize];
    }

    public void put(int key, int value) {
        int hashKey = key % bucketSize;
        if (hashMap[hashKey] == null) {
            hashMap[hashKey] = new LinkedList<>();
        } else {
            LinkedList<Integer[]> targetBucket = hashMap[hashKey];
            for (Integer[] curr : targetBucket) {
                if (curr[0] == key) {
                    curr[1] = value;
                    return;
                }
            }
        }
        hashMap[hashKey].add(new Integer[] {key, value});
    }

    public int get(int key) {
        int hashKey = key % bucketSize;
        if (hashMap[hashKey] == null) {
            return -1;
        }
        for (Integer[] curr : hashMap[hashKey]) {
            if (curr[0] == key) {
                return curr[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = key % bucketSize;
        if (hashMap[hashKey] == null) {
            return;
        }
        Iterator<Integer[]> itr = hashMap[hashKey].iterator();
        while (itr.hasNext()) {
            Integer[] curr = itr.next();
            if (curr[0] == key) {
                itr.remove();
                return;
            }
        }
    }
}
