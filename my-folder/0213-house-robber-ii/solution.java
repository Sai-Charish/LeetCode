class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int [] arr1 = new int [nums.length-1];
        int [] arr2 = new int [nums.length-1];
        for(int i=1;i<nums.length;i+=1){
            arr1[i-1] = nums[i];
        }
        for(int i=0;i<nums.length-1;i+=1){
            arr2[i] = nums[i];
        }

        return Math.max(helper(arr1),helper(arr2));
        
    }

    public int helper(int [] nums){
        int neg = 0;
        int [] dp = new int [nums.length];
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i+=1){
            int include = nums[i];
            if(i>=2){
                include += dp[i-2];
            }
            int exclude = dp[i-1];
            dp[i] = Math.max(include,exclude);
        }
        return dp[nums.length-1];
    }

}
