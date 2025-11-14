class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum%2 != 0){
            return false;
        }
        int n = nums.length;
        Boolean [][] dp  = new Boolean [n][sum+1];
        return helper(nums,n,sum,0,0,dp);
    }

    private boolean helper(int [] nums,int n, int sum,int cost,int ind,Boolean [][] dp){
        if(sum == cost){
            return true;
        }
        if(ind == n || cost > sum) {
            return false;
        }

        if(dp[ind][sum] != null){
            return dp[ind][sum];
        }

        boolean pick = helper(nums,n,sum-nums[ind],cost+nums[ind],ind+1,dp);
        boolean not_pick = helper(nums,n,sum,cost,ind+1,dp);

        dp[ind][sum] = pick | not_pick;
        return dp[ind][sum];
    } 
}
