class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }

        int res = 0;

        for(int i=0;i<nums.length;i+=1)
        {
            res = res ^ nums[i];
        }

        return res;
    }
}
