package app.idea;

import java.util.HashSet;
import java.util.Set;

public class Q36ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char number = board[i][j];

        if (number != '.' &&
          (!seen.add(number + " in row " + i) ||
            !seen.add(number + " in col " + j) ||
            !seen.add(number + " in box " + i / 3 + "-" + j / 3))) {
          // Simpler Box Logic: Using i/3 and j/3 automatically groups the cells into their respective
          // $3 \times 3$ zones.Rows 0, 1, 2 all become row/3 = 0.Cols 0, 1, 2
          // all become col/3 = 0.This maps every cell to a box index from 0-0 to 2-2.
          return false;
        }
      }
    }
    return true;
  }
}
