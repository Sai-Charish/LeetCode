class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean [] dp = new boolean [n];

        dp[n-1] = true;

        // return helper(nums,nums.length,0,dp);
        for(int i = n-2 ;i>=0;i-=1) {
            int len = Math.min(i + nums[i],n-1);
            for(int j=i+1;j <= len;j+=1){
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean helper(int [] nums,int n,int ind,boolean [] dp){
        if(ind == n-1){
            return true;
        }

        if(dp[ind] == true) {
            return dp[ind];
        }

        int len = ind + nums[ind];

        for(int i = ind;i < len;i+=1) {
            dp[ind] = dp[ind] || helper(nums,n,i+1,dp);
        }
        return dp[ind] ;
    }
}
