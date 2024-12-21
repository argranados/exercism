import java.util.ArrayList;
import java.util.List;

class GameOfLife {
    public int[][] tick(int[][] matrix){

        if (matrix.length == 0){
            return matrix;
        } else {
            return getAllCellsInMatrix(matrix);
        }
    }

    private int[][] getAllCellsInMatrix(int[][] matrix) {
        int[][] aliveCells = new int[matrix.length][matrix[0].length];
        int row, col; row = 0;

        for (int[] rowArray : matrix) {
            col = 0;
            for (int value : rowArray) {
                Position pos = new Position(row,col);
                Cell cell = new Cell(value, pos);
                var neighbords = getNeighborPositions(row, col, matrix);
                cell.setNeighbordList(neighbords);
                aliveCells[cell.pos.row][cell.pos.column] = cell.state;
                col++;
            }
            row++;
        }
        return aliveCells;
    }

    private List<Cell> getNeighborPositions(int currentRow, int currentCol, int [][] matrix) {
        List<Cell> neighbordsList = new ArrayList<>();
        int start = 0;
        int end = matrix.length-1;
        int nextRow;
        int nextCol;

        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                nextRow = currentRow + r; 
                nextCol = currentCol + c;
                //check row and colum is within limits
                //do not add self position to list
                if (!(currentRow == nextRow && currentCol == nextCol) &&
                    (nextRow >= start && nextRow <= end) && (nextCol >= start && nextCol <= end)) {
                    Position pos = new Position(nextRow, nextCol);
                    Cell neighbord = new Cell(matrix[nextRow][nextCol], pos);
                    neighbordsList.add(neighbord);
                }
            }
        }
        return neighbordsList;
    }

    class Cell {
        int state;
        Position pos;
        List<Cell> neighbordList;

        Cell(int state, Position pos){
            this.state = state;
            this.pos = pos;
        }

        public void setNeighbordList(List<Cell> neighbordList) {
            this.neighbordList = neighbordList;
            this.updateState(); // <-- HERE is where the magic happens !!!
        }

        private void updateState() {
            int countAlive = 0;
            for (Cell cell : neighbordList) {
                if (cell.state == 1) {
                    countAlive++;
                }
            }
            if (state == 0 && countAlive == 3) {
                state = 1;
            } else if (state == 1 && (countAlive == 2 || countAlive == 3)) {
                state = 1;
            } else if (countAlive < 2 || countAlive > 3) {
                state = 0;
            }
        }

        @Override
        public String toString() {
            String posList = "";
            for (Cell cell : neighbordList) {
                posList += cell.pos + " state:"+cell.state+" ,";
            }

            return "my pos "+pos +" "+
            "my state:" + state + "  " +
            "my neighb: "+ posList;
        }
    }

    class Position {
        int row;
        int column;

        Position(int x, int y) {
            this.row = x;
            this.column = y;
        }

        @Override
        public String toString() {
            return "x="+ row +":"+"y="+column;
        }
    }
}