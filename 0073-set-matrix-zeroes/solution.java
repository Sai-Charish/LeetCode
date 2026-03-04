class Solution {
    public void setZeroes(int[][] matrix) {
        //int [] col = matrix[0][..]
        //int [] row = matrix[..][0]

        int row = matrix.length;
        int col = matrix[0].length;

        int col0 = 1;

        for (int i = 0; i < row; i += 1) {
            for (int j = 0; j < col; j += 1) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < row; i += 1) {
            for (int j = 1; j < col; j += 1) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 1; i < col; i += 1) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < row; i += 1) {
                matrix[i][0] = 0;
            }
        }

        return;
    }
}
