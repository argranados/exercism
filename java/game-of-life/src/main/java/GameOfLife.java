import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GameOfLife {
    public int[][] tick(int[][] matrix){
        List<Cell> cells;
        int[][] aliveCells; 

        if (matrix.length == 0){
            return matrix;
        } else {
            cells = getAllCellsInMatrix(matrix);
            for (Cell cell : cells) {
                System.out.println(cell);
            }
            aliveCells = new int[matrix.length][matrix[0].length];
            for (Cell cell : cells) {
                aliveCells[cell.pos.row][cell.pos.column] = cell.state;
            }
        }

        return aliveCells;
    }

    private int [][] findAliveCells(List<Cell> cells) {
        int [][] aliveArray = new int [3][3];

        for (Cell cell : cells) {
            if (cell.state == 1){
                //System.out.println("alive "+ cell.pos.row + " " +cell.pos.column);
                aliveArray[cell.pos.row][cell.pos.column] = cell.state;
            }
        }
        for (int[] is : aliveArray) {
            System.out.println(Arrays.toString(is));
        }
        return aliveArray;
    }

    private List<Cell> getAllCellsInMatrix(int[][] matrix) {
        List<Cell> cellList = new ArrayList<>();
        int row, col; row = col = 0;

        for (int[] rowArray : matrix) {
            col = 0;
            for (int value : rowArray) {
                Position pos = new Position(row,col);
                Cell cell = new Cell(value, pos);
                var neighbords = getNeigbordPositions(row, col, matrix);
                //var neighbords =  getNeighbords(cell, matrix);
                cell.setNeighbordList(neighbords);
                cellList.add(cell);
                col ++;
                System.out.println();
            }
            row++;
        }
        return cellList;
    }

    private List<Cell> getNeigbordPositions(int currentRow, int currentCol, int [][] matrix) {
        List<Position> positionsList = new ArrayList<>();
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
                //and do no add self position to list
                if (!(currentRow == nextRow && currentCol == nextCol) &&
                    (nextRow >= start && nextRow <= end) && (nextCol >= start && nextCol <= end)) {
                    Position pos = new Position(nextRow, nextCol);
                    Cell neighbord = new Cell(matrix[nextRow][nextCol], pos);
                    positionsList.add(pos);
                    neighbordsList.add(neighbord);
                    //System.out.println(currentRow + ":"+ currentCol+" , "+ pos);
                }
            }
        }
        //System.out.println(positionsList);
        return neighbordsList;
    }

    private List<Cell> getNeighbords(Cell cell, int[][] matrix) {
        List<Cell> neighbords = new ArrayList<>();

        //down
        int nextRow = cell.pos.row + 1;
        if ( nextRow < matrix.length) {
            if (matrix[nextRow][cell.pos.column] == 1)
                neighbords.add(
                    new Cell(1, new Position(nextRow, cell.pos.column) )
                );
        }

        //up
        int lastRow = cell.pos.row - 1;
        if (lastRow >=0 && lastRow < matrix.length) {
            if (matrix[lastRow][cell.pos.column] == 1)
                neighbords.add(
                    new Cell(1, new Position(lastRow, cell.pos.column) )
                );
        }

        //right
        int rightColumn = cell.pos.column + 1;
        if (rightColumn < matrix.length) {
            if (matrix[cell.pos.row][rightColumn] == 1)
                neighbords.add(
                    new Cell(1, new Position(cell.pos.row, rightColumn) )
                );
        }

        //left
        int leftColumn = cell.pos.column - 1;
        if (leftColumn >= 0 && leftColumn < matrix.length) {
            if (matrix[cell.pos.row][leftColumn] == 1)
                neighbords.add(
                    new Cell(1, new Position(cell.pos.row, leftColumn) )
                );
        }

        // System.out.println(neighbords);
        return neighbords;
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
        this.updateState();
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
        boolean alive = state == 1 ? true : false;
        String posList = "";
        for (Cell cell : neighbordList) {
            posList += cell.pos + " state:"+cell.state+" ,";
        }
        
        return "my pos "+pos +" "+
        "my state:" + state + "  " +
        "my neighb: "+ posList ;
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