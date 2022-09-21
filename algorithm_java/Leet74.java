public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int row = 0;
        while (row < rows && matrix[row][cols - 1] < target)
            row++;

        if (row == rows)
            return false;

        for (int i = 0; i < cols; i++)
            if (matrix[row][i] == target)
                return true;

        return false;
    }
}
