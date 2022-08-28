import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Meeting implements Comparable<Meeting> {
    int from, to;

    public Meeting(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int compareTo(Meeting meeting) {
        if (this.to < meeting.to)
            return -1;
        if (this.to > meeting.to)
            return 1;
        if (this.from < meeting.from)
            return -1;
        return 1;
    }
}

public class Boj1931 {
    private static Meeting[] meetings;
    private static int meetingNum;

    public static void main(String[] args) throws Exception {
        int answer = 0, last = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        meetingNum = Integer.parseInt(br.readLine());
        meetings = new Meeting[meetingNum];

        for (int i = 0; i < meetingNum; i++) {
            String[] tokens = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        Arrays.sort(meetings);

        for (int i = 0; i < meetingNum; i++) {
            if (meetings[i].from >= last) {
                answer++;
                last = meetings[i].to;
            }
        }
        System.out.println(answer);
    }
}
