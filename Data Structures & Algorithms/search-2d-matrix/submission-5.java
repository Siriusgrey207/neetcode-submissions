class Solution {
    public boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (row[middle] == target) {
                return true;
            } else if (row[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // First we apply binary search for the first elements of the rows.
        int leftRow = 0;
        int rightRow = matrix.length - 1;
        int[] rowToSearch = null;

        while (leftRow <= rightRow) {
            int middleRow = leftRow + (rightRow - leftRow) / 2;
            int rowLength = matrix[0].length - 1;

            // Case: The target is in the middleRow
            if (matrix[middleRow][0] <= target && matrix[middleRow][rowLength] >= target) {
                rowToSearch = matrix[middleRow];
                break;
            }

            // Case: The target is larger than the last element of the middle row.
            if (matrix[middleRow][rowLength] < target) {
                leftRow = middleRow + 1;
            }

            /// Case: The target is smaller than the frst element of the middle row.
            if (matrix[middleRow][0] > target) {
                rightRow = middleRow - 1;
            }
        }

        if (rowToSearch == null) {
            return false;
        }

        // By this point, the row that the element is in has been discovered.
        // Next apply simple binary search on the row to find the element.

        return binarySearch(rowToSearch, target);
    }
}
