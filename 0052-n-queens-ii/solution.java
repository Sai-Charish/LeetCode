class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int [] board = new int [n];
        Arrays.fill(board,-1);
        helper(board,n,0);
        return count;
    }

     public void helper(int [] board,int n,int row) {
        if(row == n) {
            count+=1;
            return;
        }
        
        for(int i=0;i<n;i+=1){
            if(isPlaceable(board,n,row,i)){
                board[row] = i;
                helper(board,n,row+1);
                board[row] = -1;
            }
        }
                
    }

    public boolean isPlaceable(int [] board,int n,int row,int col) {
        
        for (int i = 0; i < row; i++) {
            if (board[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - board[i])) return false;
        }
        return true;
    }

}
