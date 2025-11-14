class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] res = new int [n][n];

        for(int i=0;i<queries.length;i+=1){
            int start_row = queries[i][0];
            int start_col = queries[i][1];
            int end_row = queries[i][2];
            int end_col = queries[i][3];
            increment(res,start_row,start_col,end_row,end_col);
        }

        return res;

    }

    private void increment(int [][] mat,int start_row,int start_col,int end_row,int end_col){
        for(int i=start_row;i<=end_row;i+=1){
            for(int j=start_col;j<=end_col;j+=1){
                mat[i][j] += 1;
            }
        }
        return;
    }
}
