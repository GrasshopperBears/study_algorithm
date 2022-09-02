package programmers.minimizeSalesDecrease;

import java.util.*;

class Team {
    HashSet<Integer> members = new HashSet<>();
    ArrayList<Integer> childs = new ArrayList<>();
}

class Solution {
    private static HashMap<Integer, Team> teamMap = new HashMap<>();
    private static int[] memberSales;
    private static int[][] dp;

    private static int dfsFrom(int leader, boolean selected) {
        int dpIdx = selected ? 0 : 1;
        if (dp[leader][dpIdx] >= 0)
            return dp[leader][dpIdx];

        Team team = teamMap.get(leader);
        int minSales = 0;

        if (selected) {
            if (team.childs.size() == 0)
                return 0;

            for (int child : team.childs)
                minSales += dfsFrom(child, false);
            dp[leader][dpIdx] = minSales;
            return minSales;
        }

        int currSelectMin = Integer.MAX_VALUE;
        for (int member : team.members)
            currSelectMin = Math.min(currSelectMin, memberSales[member - 1]);
        for (int child : team.childs)
            currSelectMin += dfsFrom(child, false);

        minSales = currSelectMin;
        for (int selectedChild : team.childs) {
            int childSelectSum = memberSales[selectedChild - 1];
            for (int child : team.childs)
                childSelectSum += dfsFrom(child, child == selectedChild);
            minSales = Math.min(minSales, childSelectSum);
        }
        dp[leader][dpIdx] = minSales;
        return minSales;
    }

    public static int solution(int[] sales, int[][] links) {
        memberSales = sales;
        dp = new int[sales.length + 1][2];

        for (int[] r : dp)
            Arrays.fill(r, -1);
        for (int[] link : links) {
            int leader = link[0], member = link[1];
            if (!teamMap.containsKey(leader))
                teamMap.put(leader, new Team());
            teamMap.get(leader).members.add(member);
        }
        for (int leader : teamMap.keySet()) {
            Team team = teamMap.get(leader);
            Iterator<Integer> itr = team.members.iterator();
            while (itr.hasNext()) {
                int member = itr.next();
                if (teamMap.containsKey(member)) {
                    team.childs.add(member);
                    itr.remove();
                }
            }
            team.members.add(leader);
        }
        return dfsFrom(1, false);
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[] { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 },
                new int[][] { { 10, 8 }, { 1, 9 }, { 9, 7 }, { 5, 4 }, { 1, 5 }, { 5, 10 }, { 10, 6 }, { 1, 3 }, { 10, 2 } }));
        System.out.println(solution(
                new int[] { 5, 6, 5, 3, 4 },
                new int[][] { { 2, 3 }, { 1, 4 }, { 2, 5 }, { 1, 2 } }));
        System.out.println(solution(
                new int[] { 5, 6, 5, 1, 4 },
                new int[][] { { 2, 3 }, { 1, 4 }, { 2, 5 }, { 1, 2 } }));
        System.out.println(solution(
                new int[] { 10, 10, 1, 1 },
                new int[][] { { 3, 2 }, { 4, 3 }, { 1, 4 } }));
    }
}
