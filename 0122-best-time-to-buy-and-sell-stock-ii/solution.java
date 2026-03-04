class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][] = new int [n+1][2];
        // for(int i=0 ; i<n;i+=1) {
        //     Arrays.fill(dp[i],-1);
        // }
        // int res = helper(prices,n,0,0,dp);
        // return res;

        for(int i=n-1;i>=0;i-=1){
            
                
                    dp[i][0] = Math.max(-prices[i] + dp[i+1][1] , dp[i+1][0]);
               
                    dp[i][1] = Math.max(prices[i] + dp[i+1][0], dp[i+1][1]);
                
        }

        return dp[0][0];
    }

    public int helper(int [] prices,int n,int in_hand,int start,int [][] dp) {
        if(start == n) {
            return 0;
        }
        //buy 
        if(dp[start][in_hand] != -1){
            return dp[start][in_hand];
        }
        if(in_hand == 0) {
            return dp[start][in_hand] = Math.max(-prices[start] + helper(prices,n,1,start+1,dp) , helper(prices,n,0,start+1,dp));
        }
        //sell
        else {
            return dp[start][in_hand] = Math.max(prices[start] + helper(prices,n,0,start,dp), helper(prices,n,1,start+1,dp));
        }
    }
}
