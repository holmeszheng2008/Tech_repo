package misc.math;

// 48. Rotate Image
public class Solution48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int n = length - 1;
        for(int step = 0; step < length / 2; step++){
            int i = step;
            for(int j = step; j < (n - step); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }
}
