import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine().trim());
        int[][] options = new int[caseNumber][3];
        for (int i = 0; i < caseNumber; i++) {
            String[] inputValue = br.readLine().trim().split(" ");
            int[] valueToInt = new int[3];
            for (int j = 0; j < 3; j++) {
                valueToInt[j] = Integer.parseInt(inputValue[j]);
            }
            options[i] = valueToInt;
        }

        for (int i = 0; i < caseNumber; i++) {
            int height = options[i][0];
            int order = options[i][2];

            int assignedFloor = order % height;
            int roomNumberInFloor = order / height;

            roomNumberInFloor =  assignedFloor == 0 ? roomNumberInFloor : roomNumberInFloor + 1;
            assignedFloor = assignedFloor == 0 ? height : assignedFloor;

            System.out.printf("%d%02d\n", assignedFloor, roomNumberInFloor);
        }
    }
}
