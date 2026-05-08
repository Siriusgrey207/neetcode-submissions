class Solution {
    public boolean isValidSudoku(char[][] board) {
        // First we can check if a given row has duplicate values (other than '.'). If that
        // is the case, we don't have a valid sudoku.
        for (int r = 0; r < 9; r++) {
            Set<Character> rowSet = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                char currentElement = board[r][c];

                if (rowSet.contains(currentElement)) return false;
                rowSet.add(currentElement);
            }
        }

        // Now we want to do the same for the columns.
        for (int c = 0; c < 9; c++) {
            Set<Character> columnSet = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;
                char currentElement = board[r][c];

                if (columnSet.contains(currentElement)) return false;
                columnSet.add(currentElement);
            }
        }

        // Finally we do the individual squares themselves.
        for (int sq = 0; sq <= 8; sq++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (sq / 3) * 3 + i;
                    int col = (sq % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
