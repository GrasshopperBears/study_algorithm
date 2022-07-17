import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1931 {
    private static ArrayList<int[]> require = new ArrayList<>();
    private static int meetingNum;
    private static int endTime = 0;

    public static boolean isPossible(int from, int to, boolean[] timetable) {
        for (int i = from; i < to; i++) {
            if (timetable[i]) {
                return false;
            }
        }
        return true;
    }

    public static int findMaxMeeting(int meetingIdx, boolean[] timetable) {
        int startTime = require.get(meetingIdx)[0];
        int endTime = require.get(meetingIdx)[1];

        if (meetingIdx == require.size() - 1) {
            if (isPossible(startTime, endTime, timetable)) {
                return 1;
            }
            return 0;
        }

        if (!isPossible(startTime, endTime, timetable)) {
            return findMaxMeeting(meetingIdx + 1, timetable);
        }

        int ifNotFilled = findMaxMeeting(meetingIdx + 1, timetable);
        for (int i = startTime; i < endTime; i++) {
            timetable[i] = true;
        }
        int ifFilled = findMaxMeeting(meetingIdx + 1, timetable);
        for (int i = startTime; i < endTime; i++) {
            timetable[i] = false;
        }

        return ifFilled + 1 > ifNotFilled ? ifFilled + 1 : ifNotFilled;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        meetingNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < meetingNum; i++) {
            String[] tmp = br.readLine().trim().split(" ");
            if (endTime < Integer.parseInt(tmp[1])) {
                endTime = Integer.parseInt(tmp[1]);
            }
            require.add(new int[]{Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])});
        }

        boolean[] timetable = new boolean[endTime];
        System.out.println(findMaxMeeting(0, timetable));
    }
}
