class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);

        for(int i=0;i<board.length;i+=1){
            for(int j=0;j<board[i].length;j+=1){
                if(board[i][j] == start) {
                    if(helper(board,word,i,j,0)) {
                    	return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean helper(char [][] board,String word,int i,int j,int len){
        if(len == word.length()){
            return true;
        }
        
        if(i<0 || i>board.length-1 || j<0 || j>board[i].length-1 || board[i][j] != word.charAt(len)){
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '0';

        boolean up = helper(board,word,i-1,j,len+1);

        boolean right = helper(board,word,i,j+1,len+1);

        boolean down = helper(board,word,i+1,j,len+1);

        boolean left = helper(board,word,i,j-1,len+1);
        
        board[i][j] = ch;

        return up || right || down || left;
    }
}
