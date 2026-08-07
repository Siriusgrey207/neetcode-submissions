class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // The total number of rows and columns in the matrix.
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // The most left and right elements.
        int left = 0;
        int right = ROWS * COLS - 1;

        while (left <= right) {
            // Compute the middle element and the row and col it is in.
            int middle = left + (right - left) / 2;
            int row = middle / COLS;
            int col = middle % COLS;

            // Perform binary search.
            if (target > matrix[row][col]) {
                left = middle + 1;
            } else if (target < matrix[row][col]) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
