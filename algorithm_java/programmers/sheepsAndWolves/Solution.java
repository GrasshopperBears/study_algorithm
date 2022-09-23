package programmers.sheepsAndWolves;

import java.util.*;

class Node {
    int left = -1, right = -1;
    boolean isSheep, visited = false;

    public Node(boolean isSheep) {
        this.isSheep = isSheep;
    }

    public void addChild(int child) {
        if (this.left < 0)
            this.left = child;
        else
            this.right = child;
    }
}

class Solution {
    private int maxSheeps = 0;
    private Node[] nodes;

    public void dfs(int nodeIdx, int sheeps, int wolves, ArrayList<Integer> reachable) {
        if (nodeIdx < 0)
            return;

        Node node = nodes[nodeIdx];
        if (node.isSheep)
            sheeps++;
        else
            wolves++;
        if (wolves == sheeps)
            return;

        maxSheeps = Math.max(maxSheeps, sheeps);

        if (node.left > 0)
            reachable.add(node.left);
        if (node.right > 0)
            reachable.add(node.right);

        for (int i = 0; i < reachable.size(); i++) {
            ArrayList<Integer> nextReachable = new ArrayList<>(reachable);
            int next = nextReachable.remove(i);
            dfs(next, sheeps, wolves, nextReachable);
        }
    }

    public int solution(int[] info, int[][] edges) {
        nodes = new Node[info.length];

        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(info[i] == 0);

        for (int[] edge : edges) {
            nodes[edge[0]].addChild(edge[1]);
        }
        dfs(0, 0, 0, new ArrayList<>());
        return maxSheeps;
    }
}
