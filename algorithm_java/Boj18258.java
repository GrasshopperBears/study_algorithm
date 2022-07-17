import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Boj18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList();
        int size = 0;
        String last = null;

        for (int i = 0; i < caseNum; i++) {
            String[] order = br.readLine().split(" ");
            if (order[0].equals("push")) {
                queue.offer(order[1]);
                size++;
                last = order[1];
            } else if (order[0].equals("pop")) {
                try {
                    bw.write(queue.remove());
                    size--;
                    if (size == 0) {
                        last = null;
                    }
                } catch (Exception e) {
                    bw.write("-1");
                }
            } else if (order[0].equals("size")) {
                bw.write(Integer.toString(size));
            } else if (order[0].equals("empty")) {
                bw.write(size == 0 ? "1" : "0");
            } else if (order[0].equals("front")) {
                String element = queue.element();
                if (element == null) {
                    bw.write("-1");
                } else {
                    bw.write(element);
                }
            } else if (order[0].equals("back")) {
                if (last == null) {
                    bw.write("-1");
                } else {
                    bw.write(last);
                }
            }
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
