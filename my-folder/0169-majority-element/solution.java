class Solution {
    public int majorityElement(int[] nums) {
        //moores voting alg
        int count = 1;
        int ele = nums[0];
        
        for(int i=1;i<nums.length;i+=1)
        {
            if(count == 0)
            {
                count = 1;
                ele = nums[i];
            }

            else if(nums[i] == ele)
            {
                count +=1;
            }

            else
            {
                count -=1;
            }
        }

        return ele;

        // int freq = 0;

        // for(int i=0;i<nums.length;i+=1)
        // {
        //     if(nums[i] == ele)
        //     {
        //         freq +=1;
        //     }
        // }

        // if(freq > (nums.length/2))
        // {
        //     return ele;
        // }

        // return -1;
    }
}
