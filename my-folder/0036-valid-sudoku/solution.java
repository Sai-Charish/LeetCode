class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i+=1) {
            for(int j=0;j<9;j+=1) {
                if(board[i][j] != '.'){
                    if(!isApplicable(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isApplicable(char[][] board,int row,int col,char num) {
        //row
        for(int i=0;i<9;i+=1){
            if(i!=col && board[row][i] == num){
                return false;
            }
        }
        //col
        for(int i=0;i<9;i+=1){
            if(i!=row && board[i][col] == num){
                return false;
            }
        }
        //box

        int start_row = (row/3) * 3;
        int start_col = (col/3) * 3;

        for(int i=start_row;i<start_row+3;i+=1){
            for(int j=start_col;j<start_col+3;j+=1){
                if(i != row && j!=col && board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }
}
