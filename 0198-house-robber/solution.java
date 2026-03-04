class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        int max = helper(nums,nums.length,0,dp);
        return max;
    }

    public int helper(int[] nums,int n,int start,int [] dp){
        if(start>=n){
            return 0;
        }
        if(dp[start] != -1 ) return dp[start];
        
        
        int include = nums[start] + helper(nums,n,start+2,dp);
        int exclude = helper(nums,n,start+1,dp);

        dp[start] = Math.max(include,exclude);
        return dp[start];
    }
}
