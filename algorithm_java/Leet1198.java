class Leet1198 {
    public static int smallestCommonElement(int[][] mat) {
        int answer = mat[0][0], from = 0, idx = 1, m = mat.length, n = mat[0].length;
        int[] indices = new int[mat.length];
        
        if (mat.length == 1) return answer;
        while (from != idx) {
            while (mat[idx][indices[idx]] < answer) {
                indices[idx]++;
                if (indices[idx] == n) return -1;
            }
            if (mat[idx][indices[idx]] > answer) {
                answer = mat[idx][indices[idx]];
                from = idx;
            }
            idx = (idx+1) % m;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(smallestCommonElement(new int[][]{{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}})); // 5
        System.out.println(smallestCommonElement(new int[][]{{1,2,3},{2,3,4},{2,3,5}})); // 2
    }
}
