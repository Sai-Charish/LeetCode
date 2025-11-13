class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int [n+1][n+1];
        for(int i=n-1;i>=0;i-=1){
            int m = triangle.get(i).size();
            for(int j=m-1;j>=0;j-=1){
                int cost = triangle.get(i).get(j);
                dp[i][j] = cost + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
        // return helper(triangle,n,0,0,dp);
    }

    public int helper(List<List<Integer>> triangle,int n,int i,int j,List<List<Integer>> dp){
        //base case
        if(i == n){
            return 0;
        }

        if(dp.get(i).get(j) != Integer.MAX_VALUE){
            return dp.get(i).get(j);
        }
        int left =  triangle.get(i).get(j) + helper(triangle,n,i+1,j,dp);
        int right = triangle.get(i).get(j) + helper(triangle,n,i+1,j+1,dp);
        int ans = Math.min(left,right);
        dp.get(i).set(j,ans);
        return ans; 
    }
}
