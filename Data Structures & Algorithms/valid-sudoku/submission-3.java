class Solution {
    public boolean isValidSudoku(char[][] board) {
        // First we check every row with a set and if we find a duplicate value that is not
        // a '.' the sudoku is not valid.
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                if (seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        // Secondly, we do the same for the columns. If there is a repeated char in the columns
        // the sudoku is not valid.
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') continue;
                if (seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        // Finally, we go through all the squares. we loop through the rows and columns
        // of every square. 
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
