public class Boj15596 {
    public long sum(int[] a) {
        long answer = 0;

        for (int num: a) {
            answer += num;
        }

        return answer;
    }
}
