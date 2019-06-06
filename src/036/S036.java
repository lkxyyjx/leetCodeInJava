public class S036 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = i + 1; k < 9; k++) {
                    if (board[k][j] == '.') {
                        continue;
                    } else if (board[k][j] == board[i][j]) {
                        return false;
                    }
                }

                for (int k = j + 1; k < 9; k++) {
                    if (board[i][k] == '.') {
                        continue;
                    } else if (board[i][k] == board[i][j]) {
                        return false;
                    }
                }

                for (int a = i / 3 * 3; a < i / 3 * 3 + 3; a++) {
                    for (int b = j / 3 * 3; b < j / 3 * 3 + 3; b++) {
                        if (a <= i && b <= j) {
                            a = i;
                            b = j + 1;
                        } else if (board[a][b] == '.') {
                            continue;
                        } else if (board[a][b] == board[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
