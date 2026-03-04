class Solution {
    public List<List<String>> solveNQueens(int n) {
        int [] board = new int [n];
        Arrays.fill(board,-1);
        List<List<String>> res = new ArrayList<>();
        helper(board,n,res,0);
        return res;
    }

    public void helper(int [] board,int n,List<List<String>> res,int row) {
        if(row == n) {
            addBoard(board,n,res);
            return;
        }
        
        for(int i=0;i<n;i+=1){
            if(isPlaceable(board,n,row,i)){
                board[row] = i;
                helper(board,n,res,row+1);
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

    public void addBoard(int [] board,int n,List<List<String>> res){
        List<String> curr = new ArrayList<>();
        for(int i=0;i<n;i+=1){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<n;j+=1){
                str.append(board[i] == j ? 'Q' :'.');
            }
            curr.add(str.toString());
        }
        res.add(curr);
    }
}
