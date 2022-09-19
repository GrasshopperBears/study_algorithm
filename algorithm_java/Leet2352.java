import java.util.*;;

class Node2352 {
    public HashMap<Integer, Node2352> children = new HashMap<>();
    public int cols = 0;

    public Node2352 get(int num) {
        return this.children.get(num);
    }

    public Node2352 add(int num) {
        if (this.children.containsKey(num))
            return this.children.get(num);
        Node2352 next = new Node2352();
        this.children.put(num, next);
        return next;
    }

    public void checkLast(int col) {
        this.cols++;
    }
}

class Leet2352 {
    public static int equalPairs(int[][] grid) {
        Node2352 root = new Node2352();
        int rows = grid.length, cols = grid[0].length, answer = 0;

        for (int i = 0; i < cols; i++) {
            Node2352 current = root;
            for (int j = 0; j < rows; j++) {
                current = current.add(grid[j][i]);
            }
            current.checkLast(i);
        }

        for (int i = 0; i < rows; i++) {
            Node2352 current = root;
            boolean flag = true;
            for (int j = 0; j < cols; j++) {
                current = current.get(grid[i][j]);
                if (current == null) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                answer += current.cols;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } })); // 1
        System.out.println(equalPairs(new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } })); // 3
    }
}
