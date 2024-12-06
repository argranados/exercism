import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> coordinateSet = new HashSet<>();
        var maxInRowList = getMaxInRowCoordinatesList();
        var minInColumList = getMinInColumnCoordinatesList();

        for (MatrixCoordinate pointInRow : maxInRowList){
            for (MatrixCoordinate pointInCol : minInColumList){
                if (pointInRow.equals(pointInCol)) {
                    coordinateSet.add(pointInRow);
                }
            }
        }

        return coordinateSet;
    }

    List<MatrixCoordinate> getMaxInRowCoordinatesList(){
        List<MatrixCoordinate> rowCoordinateList = new ArrayList<>();
        MatrixCoordinate coordinate;

        for (int r = 0; r < values.size(); r++) {
            int max = findMaxInRow(r);

            for (int c = 0; c < values.get(0).size(); c++) {
                if (values.get(r).get(c) == max){
                    coordinate = new MatrixCoordinate(r+1,c+1); //add 1 to fix indices - array index vs list index
                    rowCoordinateList.add(coordinate);
                }
            }
        }

        return rowCoordinateList;
    }

    List<MatrixCoordinate> getMinInColumnCoordinatesList(){
        List<MatrixCoordinate> columnCoordinateList = new ArrayList<>();
        int totalColumns = !values.isEmpty() ? values.get(0).size() : 0;
        MatrixCoordinate coordinate;

        for (int c = 0; c < totalColumns; c++) {
            int min = findMinInColumn(c);

            for (int r = 0; r < values.size(); r++) {
                if (values.get(r).get(c) == min){
                    coordinate = new MatrixCoordinate(r+1,c+1); //add 1 to fix indices - array index vs list index
                    columnCoordinateList.add(coordinate);
                }
            }
        }

        return columnCoordinateList;
    }

    int findMaxInRow(int row) {
        int max = values.get(row).get(0);

        for (int c= 0; c < values.get(0).size(); c++) {
            if (values.get(row).get(c) > max){
                max = values.get(row).get(c);
            }
        }
        System.out.println("find max " + max + " in row " + row );
        return max;
    }

    int findMinInColumn(int column) {
        // set min to first value in column to start processing
        int min = values.get(0).get(column);

        for (int r = 0; r < values.size(); r++) {
            if (values.get(r).get(column) < min) {
                min = values.get(r).get(column);
            }
        }
        System.out.println("find min " + min + " in column " + column );
        return min;
    }

}
