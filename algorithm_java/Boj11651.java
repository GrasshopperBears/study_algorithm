import java.io.*;
import java.util.ArrayList;

public class Boj11651 {
    public static ArrayList<int[]> mergeSort(ArrayList<int[]> list) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        int i = 0, j = 0, mid = size / 2;
        ArrayList<int[]> firstHalf = mergeSort(new ArrayList<>(list.subList(0, mid)));
        ArrayList<int[]> lastHalf = mergeSort(new ArrayList<>(list.subList(mid, list.size())));
        ArrayList<int[]> answer = new ArrayList<>();

        for (int k = 0; k < list.size(); k++) {
            if (i < mid && (j == size - mid || (firstHalf.get(i)[1] < lastHalf.get(j)[1]) || (firstHalf.get(i)[1] == lastHalf.get(j)[1] && firstHalf.get(i)[0] < lastHalf.get(j)[0]))) {
                answer.add(firstHalf.get(i));
                i++;
            } else {
                answer.add(lastHalf.get(j));
                j++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws  Exception {
        ArrayList<int[]> ls = new ArrayList<>();
        int caseNum;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            String[] ip = br.readLine().trim().split(" ");
            ls.add(new int[]{Integer.parseInt(ip[0]), Integer.parseInt(ip[1])});
        }
        br.close();

        ls = mergeSort(ls);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < caseNum; i++) {
            bw.write(ls.get(i)[0] + " " + ls.get(i)[1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
