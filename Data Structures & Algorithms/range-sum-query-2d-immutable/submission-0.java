class NumMatrix {
    int[][] matrix;
    int rows;
    int cols;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.rows == 0) return 0;
        int runningSum = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                int value = matrix[i][j];
                runningSum += value;
            }
        }

        return runningSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */