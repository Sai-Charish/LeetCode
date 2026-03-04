class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int max = 0;

        for(int i=0;i<nums.length;i+=1)
        {
            if(nums[i] == 1)
            {
                res+=1;
            }
            else
            {
                res = 0;
            }

            max = Math.max(res,max);
        }

        return max;

    }
}
