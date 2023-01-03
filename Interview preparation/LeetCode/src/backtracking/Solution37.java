package backtracking;

import java.util.HashSet;
import java.util.Set;

// 37. Sudoku Solver
public class Solution37 {
    private Set<String> memoSet = new HashSet<>();
    private char[][] board;
    private boolean resGot = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i =0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    String rowString = genRowString(i, num);
                    String colString = genColString(j, num);
                    String blockString = genBlockString(i/3, j/3, num);
                    memoSet.add(rowString);
                    memoSet.add(colString);
                    memoSet.add(blockString);
                }
            }
        }

        backtracking(0, 0);
    }

    private void backtracking(int i, int j){
        if(i == 9 || j == 9){
            return;
        }
        if(board[i][j] != '.') {
            if(i == 8 && j == 8) {
                resGot = true;
                return;
            }
            // one level deeper
            int[] nextPosition = getNextPosition(i, j);
            backtracking(nextPosition[0], nextPosition[1]);

        } else {
            for(int num = 1; num <= 9; num++){
                String rowString = genRowString(i, num);
                String colString = genColString(j, num);
                String blockString = genBlockString(i/3, j/3, num);
                if(memoSet.contains(rowString) || memoSet.contains(colString) || memoSet.contains(blockString)){
                    continue;
                }

                memoSet.add(rowString);
                memoSet.add(colString);
                memoSet.add(blockString);
                board[i][j] = (char)(num + '0');

                if(i == 8 && j == 8) {
                    resGot = true;
                    return;
                } else {
                    int[] nextPosition = getNextPosition(i, j);
                    backtracking(nextPosition[0], nextPosition[1]);
                    if(resGot){
                        return;
                    }
                }

                memoSet.remove(rowString);
                memoSet.remove(colString);
                memoSet.remove(blockString);
                board[i][j] = '.';
            }
        }

    }

    private String genRowString(int i, int num) {
        return num + "- in row " + i;
    }

    private String genColString(int j, int num) {
        return num + "- in col " + j;
    }

    private String genBlockString(int i, int j, int num) {
        return num + "- in block " + i + "-" + j;
    }

    private int[] getNextPosition(int i, int j){
        j++;
        if(j == 9){
            i++;
            j = 0;
        }
        return new int[]{i, j};
    }
}
