package array_linked_list;

import java.util.HashSet;
import java.util.Set;

// 36. Valid Sudoku
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if (Character.isDigit(c)){
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }
            }
            set.clear();
        }

        for(int j = 0; j < board[0].length; j++){
            for(int i = 0; i < board.length; i++){
                char c = board[i][j];
                if (Character.isDigit(c)){
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }
            }
            set.clear();
        }

        for(int w = 0; w <= 6; w+=3){
            for(int k = 0; k <= 6; k+=3){
                for(int i = w; i <w+3; i++){
                    for(int j = k; j < k+3; j++){
                        char c = board[i][j];
                        if (Character.isDigit(c)){
                            if(set.contains(c)){
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
                set.clear();
            }
        }

        return true;
    }
}
