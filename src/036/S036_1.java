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
        Map<Integer, Integer>[] rowCount = new HashMap[9];
        Map<Integer, Integer>[] colCount = new HashMap[9];
        Map<Integer, Integer>[] cubCount = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rowCount[i] = new HashMap<>();
            colCount[i] = new HashMap<>();
            cubCount[i] = new HashMap<>();
        }
        int nowInt;
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    nowInt = (int)board[i][j];
                    rowCount[i].put(nowInt, rowCount[i].getOrDefault(nowInt, 0) + 1);
                    colCount[j].put(nowInt, colCount[j].getOrDefault(nowInt, 0) + 1);
                    cubCount[i / 3 * 3 + j / 3].put(nowInt, cubCount[i / 3 * 3 + j / 3].getOrDefault(nowInt, 0) + 1);
                    if (rowCount[i].get(nowInt) > 1 || colCount[j].get(nowInt) > 1 || cubCount[i/3 * 3 + j/3].get(nowInt) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
