import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // comparator for TreeSet
    public int compareTo(Point point) {
        if (this.y == point.y)
            return this.x > point.x ? 1 : -1;
        return this.y > point.y ? 1 : -1;
    }
}

public class Boj2261 {
    private static int horizontalDist(Point p1, Point p2) {
        return p2.x - p1.x;
    }

    private static int verticallDist(Point p1, Point p2) {
        return p2.y - p1.y;
    }

    public static int getDistSquare(Point p1, Point p2) {
        int xDiff = horizontalDist(p1, p2);
        int yDiff = verticallDist(p1, p2);
        return xDiff * xDiff + yDiff * yDiff;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] coordinates = new Point[N];

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            coordinates[i] = new Point(x, y);
        }
        Arrays.sort(coordinates, (p1, p2) -> p1.x > p2.x ? 1 : -1);

        int minDistSquare = getDistSquare(coordinates[0], coordinates[1]);
        int minDist = (int) Math.ceil(Math.sqrt(minDistSquare));
        TreeSet<Point> candidates = new TreeSet<>();
        candidates.add(coordinates[0]);
        candidates.add(coordinates[1]);

        for (int i = 2; i < N; i++) {
            Point point = coordinates[i];
            Iterator<Point> candSetItr = candidates.iterator();
            while (candSetItr.hasNext()) {
                Point candidate = candSetItr.next();
                int xDiff = verticallDist(candidate, point);
                if (xDiff > minDistSquare)
                    candSetItr.remove();
            }

            candidates.add(point);
        }

        System.out.println(minDistSquare);
    }
}
