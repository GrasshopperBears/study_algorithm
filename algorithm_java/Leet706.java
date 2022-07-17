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

class Leet706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
