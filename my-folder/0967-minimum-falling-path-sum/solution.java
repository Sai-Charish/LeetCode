class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int [n][n];
        for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int res = helper(matrix,n,0,0,dp);
        return res;
    }

    public int helper(int [][] matrix,int n,int i,int j,int [][] dp){
        if(i>=n || j<0 || j>=n) return 100000;

        if(i == n-1) return matrix[i][j];

        if(dp[i][j] != Integer.MAX_VALUE ) return dp[i][j];

        int include_left = matrix[i][j] + helper(matrix,n,i+1,j-1,dp);
        int include_right = matrix[i][j] + helper(matrix,n,i+1,j+1,dp);
        int include_bottom = matrix[i][j] + helper(matrix,n,i+1,j,dp);
        
        dp[i][j] = Math.min(include_left,Math.min(include_right,include_bottom));
        

        if(i==0){
            int exclude = helper(matrix,n,i,j+1,dp);
            dp[i][j] = Math.min(dp[i][j],exclude);
            return dp[i][j];
        }

        return dp[i][j];

       
    }
}
