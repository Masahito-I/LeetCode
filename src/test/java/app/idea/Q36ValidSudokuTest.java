package app.idea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Q36ValidSudokuTest {

  private final Q36ValidSudoku solution = new Q36ValidSudoku();

  @Test
  void testValidSudokuExample1() {
    char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    assertTrue(solution.isValidSudoku(board), "Example 1 should be valid");
  }

  @Test
  void testInvalidSudokuExample2() {
    // Same as Example 1, but the (0,0) element is '8' instead of '5'
    // This causes two '8's in the first column and the first 3x3 box
    char[][] board = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    assertFalse(solution.isValidSudoku(board), "Example 2 should be invalid due to duplicate 8s");
  }

  @Test
  void testEmptyBoard() {
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = '.';
      }
    }
    assertTrue(solution.isValidSudoku(board), "An empty board is technically valid");
  }

  @Test
  void testColumnViolation() {
    char[][] board = createEmptyBoard();
    board[0][0] = '1';
    board[8][0] = '1'; // Duplicate 1 in the first column
    assertFalse(solution.isValidSudoku(board), "Should be invalid: duplicate in column");
  }

  private char[][] createEmptyBoard() {
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      java.util.Arrays.fill(board[i], '.');
    }
    return board;
  }
}