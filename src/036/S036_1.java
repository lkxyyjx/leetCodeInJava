import java.util.HashMap;
import java.util.Map;

public class S036_1 {

    public static void main(String[] args) {
        S036_1 solution = new S036_1();
        System.out.println(solution.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rowCount = new int[9][9];
        int[][] colCount = new int[9][9];
        int[][] cubCount = new int[9][9];
        int nowInt;
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    nowInt = board[i][j] - '1';
                    rowCount[i][nowInt] ++;
                    colCount[j][nowInt] ++;
                    cubCount[i / 3 * 3 + j / 3][nowInt] ++;
                    if (rowCount[i][nowInt] > 1 || colCount[j][nowInt] > 1 || cubCount[i/3 * 3 + j/3][nowInt] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
