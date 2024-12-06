import java.util.Arrays;
import java.util.stream.IntStream;

class Matrix {
    String matrixAsString;
    int[][] matrix;


    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        String[] rowsArrays = matrixAsString.split("\n");
        matrix = new int[rowsArrays.length][];
        int row=0;

        for (String rowStr : rowsArrays) {
            String[] strArray = rowStr.split(" ");
            int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
            matrix[row++] = intArray;
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber-1];
    }

    int[] getColumn(int columnNumber) {
        return IntStream.range(0, matrix.length).map(i ->matrix[i][columnNumber-1]).toArray();
    }
}
