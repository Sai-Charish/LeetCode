class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int [][]dp = new int [row][col];
        for(int i=0;i<row;i+=1){
            for(int j=0;j<col;j+=1){
                dp[i][j] = -1;
            }
        }
        int res = helper(obstacleGrid,row,col,0,0,dp);
        return res;
    }
    
    public int helper(int [][] obstacleGrid,int row,int col,int i,int j,int [][] dp){
        if(i>=row || j>=col || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == row-1 && j==col-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down  = helper(obstacleGrid,row,col,i+1,j,dp);
        int right = helper(obstacleGrid,row,col,i,j+1,dp);
        
        dp[i][j] = down+right;
        return dp[i][j];

    }
}
