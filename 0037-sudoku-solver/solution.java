class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
        return;
    }

    public boolean helper(char [][] board){
        for(int i=0;i<9;i+=1){
            for(int j=0;j<9;j+=1){
                if(board[i][j] == '.') {
                    for(char ch = '1';ch<='9';ch+=1){
                        if(isApplicable(board,ch,i,j)){
                            board[i][j] = ch;
                            if(helper(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isApplicable(char[][] board, char ch,int row,int col){
        //row
        for(int i=0;i<9;i+=1){
            if(ch == board[row][i]){
                return false;
            }
        }

        //col
        for(int i=0;i<9;i+=1){
            if(ch == board[i][col]){
                return false;
            }
        }
        //box
        int start_row = (row/3) * 3;
        int start_col = (col/3) * 3;

        for(int i = start_row ; i< start_row+3;i+=1) {
            for(int j = start_col ; j < start_col+3 ;j+=1){
                if(ch == board[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
