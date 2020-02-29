import java.util.*;

public class S079 {
    boolean res = false;
    int rowsNum;
    int colsNum;
    boolean used[][];
    public boolean exist(char[][] board, String word) {
        if (word.length() < 1) return false;
        rowsNum = board.length;
        if (rowsNum < 1) return res;
        colsNum = board[0].length;
        if (colsNum < 1) return res;
        used = new boolean[rowsNum][colsNum];
        for (int i = 0; i < rowsNum; i ++) {
            for (int j = 0; j < colsNum; j ++) {
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    backTrack(board, word, i, j, 0);
                    used[i][j] = false;
                }
            }
        }
        return res;
    }

    public void backTrack(char[][] board, String word, int curRow, int curCol, int curCharPos) {
        if (res) return;
        if (curCharPos == word.length() - 1) {
            res = true;
            return;
        } else {
            curCharPos ++;
        }
        if (curRow + 1 < rowsNum && !used[curRow + 1][curCol]  && board[curRow + 1][curCol] == word.charAt(curCharPos)) {
            used[curRow + 1][curCol] = true;
            backTrack(board, word, curRow + 1, curCol, curCharPos);
            used[curRow + 1][curCol] = false;
        }
        if (curRow - 1 >= 0 && !used[curRow - 1][curCol]  && board[curRow - 1][curCol] == word.charAt(curCharPos)) {
            used[curRow - 1][curCol] = true;
            backTrack(board, word, curRow - 1, curCol, curCharPos);
            used[curRow - 1][curCol] = false;
        }
        if (curCol + 1 < colsNum && !used[curRow][curCol + 1]  && board[curRow][curCol + 1] == word.charAt(curCharPos)) {
            used[curRow][curCol + 1] = true;
            backTrack(board, word, curRow, curCol + 1, curCharPos);
            used[curRow][curCol + 1] = false;
        }
        if (curCol - 1 >= 0 && !used[curRow][curCol - 1]  && board[curRow][curCol - 1] == word.charAt(curCharPos)) {
            used[curRow][curCol - 1] = true;
            backTrack(board, word, curRow, curCol - 1, curCharPos);
            used[curRow][curCol - 1] = false;
        }
    }

    public static void main(String[] str) {
        S079 solution = new S079();
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(solution.exist(board, word));
    }
}
