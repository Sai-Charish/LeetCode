class Solution {
    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        int count = helper(m,n,0,0,dp);
        return count;
    }
    public int helper(int m,int n,int i,int j,int [][] dp) {
        if(i>=m || j>=n ) return 0;
        if(i==m-1 && j==n-1) return 1;

        if(dp[i][j] != 0) return dp[i][j];

        int a = helper(m,n,i+1,j,dp);
        int b = helper(m,n,i,j+1,dp);
        dp[i][j] = a+b;
        return dp[i][j];
    }
}
