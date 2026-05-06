class NumMatrix {
    // A matrix that stores the sum of all the elements above and to the left.
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // The prefix matrix has a size +1 rows and +1 columns.
        prefix = new int[rows + 1][cols + 1];

        // Every element in prefix now contains the value of all the elements above
        // and to the left of it.
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                prefix[r][c] = matrix[r - 1][c - 1]
                    + prefix[r - 1][c]
                    + prefix[r][c - 1]
                    - prefix[r - 1][c - 1];
            }
        }
        // r and c are rows and columns in the prefix matrix.
    }

    // Method that uses the prefix matrix to quickly access the already-calculated
    // sum.
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
            - prefix[row1][col2 + 1]
            - prefix[row2 + 1][col1]
            + prefix[row1][col1];
    }
}