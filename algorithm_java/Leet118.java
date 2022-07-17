import java.util.*;

class Leet118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> prev = new ArrayList<>(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> next = new ArrayList<>(i+1);
            next.add(1);
            for (int j = 1; j < i; j++) {
                next.add(prev.get(j-1) + prev.get(j));
            }
            next.add(1);
            answer.add(prev);
            prev = next;
        }
        answer.add(prev);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(generate(1)); // [[1]]
    }
}
