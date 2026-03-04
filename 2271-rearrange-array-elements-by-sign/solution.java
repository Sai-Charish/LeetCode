class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] arr = new int [nums.length];

        // int i=0;
        // int j=0;
        // int k=0;

        // while(i<nums.length && j<nums.length)
        // {
        //     while(nums[i] < 0)
        //     {
        //         i+=1;
        //     }
        //     arr[k] = nums[i];
        //     k+=1;
        //     while(nums[j] > 0)
        //     {
        //         j+=1;
        //     }

        //     arr[k] = nums[j];
        //     k+=1;

        //     i+=1;
        //     j+=1;
        // }

        int j=0;
        int k=1;

        for(int i=0;i<nums.length;i+=1)
        {
            if(nums[i] > 0)
            {
                arr[j] = nums[i];
                j+=2;
            }
            else
            {
                arr[k] = nums[i];
                k+=2;
            }
        }


        return arr;
    }
}
