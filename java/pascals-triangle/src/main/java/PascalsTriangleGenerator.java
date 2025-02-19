class PascalsTriangleGenerator {

    //copilot
    int[][] generateTriangle(int rows) {
        int[][] triangle = new int[rows][];
        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = pascalValue(i, j);
            }
        }
        return triangle;
    }

    //deepseek
    public int pascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        return pascalValue(row - 1, col - 1) + pascalValue(row - 1, col);
    }



}