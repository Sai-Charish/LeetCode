class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp = new int [strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i+=1){
            for(int j=0;j<m+1;j+=1){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(strs,m,n,0,0,0,dp);
    }

    public int helper(String[] strs,int m,int n,int count_0,int count_1,int ind,int [][][] dp){
        //base case
        if(count_0 > m || count_1 > n) {
            return Integer.MIN_VALUE;
        }
        if(ind == strs.length) {
            return 0;
        }

        if(dp[ind][count_0][count_1] != -1){
            return dp[ind][count_0][count_1];
        }

        int [] cnt = new int [2];
        
        cnt = numOf10(strs[ind]);
        
        int pick = 1 + helper(strs,m,n,count_0+cnt[0],count_1+cnt[1],ind+1,dp);
        
        int not_pick = helper(strs,m,n,count_0,count_1,ind+1,dp);
        return dp[ind][count_0][count_1] = Math.max(pick,not_pick);
    }

    public int [] numOf10(String str){
        int [] res = new int[2];

        for(int i=0;i<str.length();i+=1) {
            if(str.charAt(i) == '0'){
                res[0] += 1; 
            }
            else {
                res[1] += 1;
            }
        }
        return res;
    }
}
