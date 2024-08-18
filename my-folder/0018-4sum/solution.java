class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        if(nums.length < 4 || target == Integer.MAX_VALUE ||target == Integer.MIN_VALUE)
        {
            return result;
        }
 
        
        int low;
        int high;

        for(int j = 0; j < nums.length - 3 ; j+=1)
        {
            if(j>0 && nums[j] == nums[j-1])
            {
                continue;
            }

            for(int i = j+1;i < nums.length-2;i+=1)
            {
                if(i>j+1 && nums[i] == nums[i-1])
                {
                  continue;
                }

                low = i+1;
                high = nums.length-1;

                while(low < high)
                {
                    long current_sum = (long)nums[j] + nums[i] +nums[low] + nums[high];
                    if(current_sum == target)
                    {
                        result.add(Arrays.asList(nums[j] , nums[i] , nums[low] , nums[high]));
                        while(low < high && nums[low] == nums[low+1])
                        {
                            low+=1;
                        }
                        while(low < high && nums[high] == nums[high-1])
                        {
                            high-=1;

                        }
                        low+=1;
                        high-=1;
                    }
                    else if(current_sum < target)
                    {
                        low+=1;
                    }
                    else
                    {
                        high -=1;
                    }
                    
                }


            }
        }

        
        return result;
        
    }
}
