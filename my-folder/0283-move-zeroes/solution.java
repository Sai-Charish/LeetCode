class Solution {
    public void moveZeroes(int[] nums) {
        int i=1;
        int j=0;

        while(i<nums.length)
        {
            while(i<nums.length  && nums[i]==0)
            {
                i+=1;
            }

            if(i >= nums.length)
            {
                break;
            }

            while(j<i && nums[j]!=0)
            {
                j+=1;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i+=1;
            j+=1;
        }
    }

    public void swap(int[] arr ,int i,int j)
    {
        
        return;
    }
}
