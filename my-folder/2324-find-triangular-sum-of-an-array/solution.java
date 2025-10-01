class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length-1;
        for(int i=0;i<=n;i+=1)
        {
            for(int j=n;j>i;j-=1)
            {
                nums[j] = nums[j] + nums[j-1];
                nums[j] = nums[j]%10;
            }
        }

        return nums[n];
        
    }
}
