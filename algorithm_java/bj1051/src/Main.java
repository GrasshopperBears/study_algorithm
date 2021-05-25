import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split(" ");
        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        String[][] numberInfo = new String[height][width];
        int maxArea = 1;

        for (int i = 0; i < height; i++) {
            String[] line = br.readLine().trim().split("");
            numberInfo[i] = line;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String curr = numberInfo[i][j];
                ArrayList<Integer> sameNumberList = sameNumberInLine(numberInfo[i], j+1, curr);
                if (sameNumberList.size() == 0) continue;
                for (int k = 0; k < sameNumberList.size(); k++) {
                    int squareSize = sameNumberList.get(k) - j;
                    int bottomY = i + squareSize;
                    if (bottomY >= height) break;
                    if (numberInfo[bottomY][j].equals(curr) && numberInfo[bottomY][sameNumberList.get(k)].equals(curr)){
                        maxArea = Math.max(maxArea, (squareSize + 1) * (squareSize + 1));
                    }
                }
            }
        }
        System.out.println(maxArea);
    }

    public static ArrayList<Integer> sameNumberInLine(String[] line, int from, String ch){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = from; i < line.length; i++) {
            if (line[i].equals(ch)){
                result.add(i);
            }
        }
        return result;
    }
}
