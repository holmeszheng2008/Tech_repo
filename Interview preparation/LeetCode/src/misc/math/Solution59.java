package misc.math;

// 59. Spiral Matrix II
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];
        int lastStep = (n-1) / 2;
        int num = 1;
        for(int step = 0; step <= lastStep; step++) {
            int initI = step, initJ = step;
            int maxI = n-1-step, maxJ = n-1-step;

            if(initI == maxI){
                matrix[initI][initJ] = num++;
            } else {
                for(int i = initI, j = initJ; j < maxJ; j++){
                    matrix[i][j] = num++;
                }
                for(int i = initI, j = maxJ; i < maxI; i++){
                    matrix[i][j] = num++;
                }
                for(int i = maxI, j = maxJ; j > initJ; j--){
                    matrix[i][j] = num++;
                }
                for(int i = maxI, j = initJ; i > initI; i--){
                    matrix[i][j] = num++;
                }
            }
        }

        return matrix;
    }
}
