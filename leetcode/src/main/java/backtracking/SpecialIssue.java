package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: redvelet
 * createTime: 2023/12/24
 * description:
 */
public class SpecialIssue {
    //N皇后问题
    public List<List<String>> solveNQueens(int n) {
        //1.确定参数
        List<List<String>> result = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        dfs(result, chessboard, n, 0);
        return result;
    }

    private void dfs(List<List<String>> result, char[][] chessboard, int n, int startRow) {
        if (startRow == n) {
            collectResult(result, chessboard);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(startRow, col, n, chessboard)) {
                chessboard[startRow][col] = 'Q';
                dfs(result, chessboard, n, startRow + 1);
                chessboard[startRow][col] = '.';
            }
        }
    }

    private void collectResult(List<List<String>> result, char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        result.add(list);
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------------------------
    //解数独
    public void solveSudoku(char[][] board) {
        dfsSuDu(board);
    }

    private boolean dfsSuDu(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (dfsSuDu(board)) {
                            return true;
                        } else {
                            //如果递归进去的下一个数字不符合要求则需要撤回操作
                            board[i][j] = '.';
                        }

                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char tar) {
        //行重复判断
        for (int i = 0; i < col; i++) {
            if (board[row][i] == tar) {
                return false;
            }
        }
        //列重复判断
        for (int i = 0; i < row; i++) {
            if (board[i][col] == tar) {
                return false;
            }
        }
        //横线内3*3的九宫格判断
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[startRow][startCol] == tar) {
                    return false;
                }
            }
        }
        return true;
    }


}
