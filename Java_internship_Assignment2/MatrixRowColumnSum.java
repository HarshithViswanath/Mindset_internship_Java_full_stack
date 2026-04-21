public class MatrixRowColumnSum {
    public static void main(String[] args) {

        int[][] a = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // Row sums
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++)
                rowSum += a[i][j];
            System.out.println("Row " + i + " sum = " + rowSum);
        }

        // Column sums
        for (int j = 0; j < 3; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++)
                colSum += a[i][j];
            System.out.println("Column " + j + " sum = " + colSum);
        }
    }
}
