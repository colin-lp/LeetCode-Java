public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = true, col = true;
        //如果0行 0列中有0，则做标记
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) col = false;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) row = false;
        }
        //将其他行列中有0的标记在0行0列中
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //根据0行0列中的标记判断该行该列是否置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //如果0行0列有0，则都置为0
        if (!row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (!col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
