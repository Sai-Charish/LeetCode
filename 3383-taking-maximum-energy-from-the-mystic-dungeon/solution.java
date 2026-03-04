class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int res = Integer.MIN_VALUE;
        int [] dp = new int [energy.length];
        Arrays.fill(dp,10000);
        for(int i=0;i<energy.length;i+=1)
        {
            int sum = helper(energy,energy.length,k,i,dp);
            res = Math.max(sum,res);
        }
        return res;
    }

    public int helper(int[] energy,int n,int k,int start,int []dp){
        if(start>=n) return 0;
        if(dp[start] != 10000) return dp[start];
        dp[start] = energy[start] + helper(energy,n,k,start+k,dp);
        return dp[start];
    }
}
