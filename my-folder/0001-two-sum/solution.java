class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int size = nums.length;
        int checker;

        for(int i=0;i<size;i+=1)
        {
            checker = target - nums[i];
            for(int j=i+1;j<size;j+=1)
            {
                if(nums[j]==checker)
                {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
            
        }

        return res;


    }
}
