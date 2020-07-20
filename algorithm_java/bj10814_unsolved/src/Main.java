import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static TreeMap<Integer, String> makeTreeMap(int x, String s) {
        TreeMap<Integer, String> tmp = new TreeMap<>();
        tmp.put(x, s);
        return tmp;
    }

    public static SortedMap<Integer, TreeMap<Integer, String>> mergeSort(SortedMap<Integer, TreeMap<Integer, String>> ls) {
        int size = ls.size();
        if (size <= 1) {
            return ls;
        }

        int mid = size / 2;
        SortedMap<Integer, TreeMap<Integer, String>> firstHalf = mergeSort(ls.headMap(mid));
        SortedMap<Integer, TreeMap<Integer, String>> lastHalf = mergeSort(ls.tailMap(mid));
        SortedMap<Integer, TreeMap<Integer, String>> answer = new TreeMap<>();
        Set setOfFirst = firstHalf.entrySet();
        Set setOfLast = lastHalf.entrySet();
        Iterator itrOfFirst = setOfFirst.iterator();
        Iterator itrOfLast = setOfLast.iterator();

        while (itrOfFirst.hasNext() && itrOfLast.hasNext()) {
            if (!itrOfFirst.hasNext()) {
                Map.Entry<Integer, TreeMap<Integer, String>> element = (Map.Entry<Integer, TreeMap<Integer, String>>) itrOfLast.next();
                answer.put(element.getKey(), element.getValue());
                continue;
            } else if (!itrOfLast.hasNext()) {
                Map.Entry<Integer, TreeMap<Integer, String>> element = (Map.Entry<Integer, TreeMap<Integer, String>>) itrOfFirst.next();
                answer.put(element.getKey(), element.getValue());
                continue;
            }
            Map.Entry<Integer, TreeMap<Integer, String>> elementOfFirst = (Map.Entry<Integer, TreeMap<Integer, String>>) itrOfFirst.next();
            Map.Entry<Integer, TreeMap<Integer, String>> elementOfLast = (Map.Entry<Integer, TreeMap<Integer, String>>) itrOfLast.next();
            int firstAge = elementOfFirst.getValue().firstKey();
            int lastAge = elementOfLast.getValue().firstKey();

            if (firstAge < lastAge) {
                answer.put(elementOfFirst.getKey(), elementOfFirst.getValue());
            } else if (firstAge > lastAge) {
                answer.put(elementOfLast.getKey(), elementOfLast.getValue());
            } else {

            }



        }




        for (Map.Entry<Integer, TreeMap<Integer, String>> entryOfFirst: firstHalf.entrySet()) {
            for (Map.Entry<Integer, TreeMap<Integer, String>> entryOfLast: lastHalf.entrySet()) {
                if (entryOfFirst.getValue().firstKey() > entryOfLast.getValue().firstKey()) {
                    answer.put(entryOfLast.getKey(), entryOfLast.getValue());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        SortedMap<Integer, TreeMap<Integer, String>> list = new TreeMap<>();

        for (int i = 0; i < caseNum; i++) {
            String[] ip = br.readLine().trim().split(" ");
            list.put(i, makeTreeMap(Integer.parseInt(ip[0]), ip[1]));
        }

        list = mergeSort(list);

    }
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Main {
//
//
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int caseNum = Integer.parseInt(br.readLine());
//        ArrayList<Integer> ages = new ArrayList<>();
//        ArrayList<String> names = new ArrayList<>();
//
//        for (int i = 0; i < caseNum; i++) {
//            String[] ip = br.readLine().trim().split(" ");
//            ages.add(Integer.parseInt(ip[0]));
//            names.add(ip[1]);
//        }
//
//
//
//
//    }
//}
