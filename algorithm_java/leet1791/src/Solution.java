class Solution {
    public static int findCenter(int[][] edges) {
        int[] u = edges[0];
        int[] v = edges[1];
        if (u[0] == v[0] || u[0] == v[1]) return u[0];
        return u[1];
    }

    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2},{2,3},{4,2}})); // 2
        System.out.println(findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}})); // 1
    }
}