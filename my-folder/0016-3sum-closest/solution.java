class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest_sum = nums[0]+nums[1]+nums[2];
        int current_sum;

        int low;
        int high;
        for(int i = 0; i < nums.length-2 ; i+=1)
        {
            low = i+1;
            high = nums.length - 1;
            while(low < high)
            {
                current_sum = nums[i]+nums[low]+nums[high];

                if(Math.abs(current_sum - target) < Math.abs(closest_sum - target))
                {
                    closest_sum = current_sum;
                }

                if(current_sum < target)
                {
                    low+=1;
                }
                else if(current_sum > target)
                {
                    high -= 1;
                }
                else
                {
                    return closest_sum;
                }


            }
        }

        return closest_sum;
    }
}
