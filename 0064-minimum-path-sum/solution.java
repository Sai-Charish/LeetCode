class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int [row][col];
        long res = helper(grid,row,col,0,0,dp);
        
        return (int)res;
    }

    public long helper(int[][] grid,int row,int col,int i,int j,int [][] dp) {
        if(i>=row || j>=col){
            return Integer.MAX_VALUE;
        }

        if(i == row-1 && j == col-1) {
            return grid[i][j];
        }

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        long down = grid[i][j] + helper(grid,row,col,i+1,j,dp);
        long right = grid[i][j] + helper(grid,row,col,i,j+1,dp);

        dp[i][j] =(int)Math.min(down,right);
        return dp[i][j];
    }

}
