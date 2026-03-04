class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int [][] dp = new int [n][m];
        for(int i=0;i<m;i+=1){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        // return helper(triangle,n,0,0,dp);

        for(int i=n-2;i>=0;i-=1){
            for(int j=triangle.get(i).size()-1;j>=0;j-=1){
                int left = triangle.get(i).get(j) + dp[i+1][j];
                int right = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(left,right);
            }
        }

        return dp[0][0];
    }

    public int helper(List<List<Integer>> triangle,int n,int i,int j,int [][] dp){
        if(i == triangle.size() || j == triangle.get(i).size()){
            return 0;
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = triangle.get(i).get(j) + helper(triangle,n,i+1,j,dp);
        int right = triangle.get(i).get(j) + helper(triangle,n,i+1,j+1,dp);

        return dp[i][j] = Math.min(left,right);
    }
}
