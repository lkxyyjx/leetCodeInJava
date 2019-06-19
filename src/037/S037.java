import java.util.Stack;

public class S037 {
    public static void main(String[] args) {
        S037 solution = new S037();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            String s = "";
            for (int j = 0; j < 9; j++) {
                s += board[i][j];
            }
            System.out.println(s);
        }

    }

    public void solveSudoku(char[][] board) {
        int[][] rowCount = new int[9][9];
        int[][] colCount = new int[9][9];
        int[][] cubCount = new int[9][9];
        int nowInt;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    nowInt = board[i][j] - '1';
                    rowCount[i][nowInt]++;
                    colCount[j][nowInt]++;
                    cubCount[i / 3 * 3 + j / 3][nowInt]++;
                }
            }
        }

        Stack<pair> fillProcessor = new Stack<>();
        boolean isFillable;
        pair pos;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    isFillable = false;
                    for (int v = 0; v < 9; v++ ) {
                        if (rowCount[i][v] < 1 && colCount[j][v] < 1 && cubCount[i / 3 * 3 + j / 3][v] < 1) {
                            fillProcessor.push(new pair(i, j));
                            board[i][j] = (char)(v + '1');
                            isFillable = true;
                            rowCount[i][v] ++;
                            colCount[j][v] ++;
                            cubCount[i / 3 * 3 + j / 3][v] ++;
                            break;
                        }
                    }
                    if (!isFillable) {
                        backTrack(board, fillProcessor, rowCount, colCount, cubCount);
                        pos = fillProcessor.peek();
                        if (pos == null) {
                            board = new char[9][9];
                            return;
                        } else {
                            i = pos.x;
                            j = pos.y;
                            if (i == 0 && j == 8) return;
                        }
                    }
                }
            }
        }
    }

    private void backTrack(char[][] board, Stack<pair> fillProcessor, int[][] rowCount, int[][] colCount, int[][] cubCount) {
        boolean trackingBackOk = false;
        pair pos;
        int posValue;
        int i;
        int j;

        while (!trackingBackOk) {
            pos = fillProcessor.pop();
            if (pos != null) {
                i = pos.x;
                j = pos.y;
                posValue = board[i][j] - '1';
                board[i][j] = '.';
                rowCount[i][posValue]--;
                colCount[j][posValue]--;
                cubCount[i / 3 * 3 + j / 3][posValue]--;
                for (int v = posValue + 1; v < 9; v++) {
                    if (rowCount[i][v] < 1 && colCount[j][v] < 1 && cubCount[i / 3 * 3 + j / 3][v] < 1) {
                        fillProcessor.push(new pair(i, j));
                        board[i][j] = (char) (v + '1');
                        trackingBackOk = true;
                        rowCount[i][v]++;
                        colCount[j][v]++;
                        cubCount[i / 3 * 3 + j / 3][v]++;
                        break;
                    }
                }
            } else {
                trackingBackOk = true;
            }
        }
    }

    public static class pair {
        public int x;
        public int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

