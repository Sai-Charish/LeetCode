class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length-1;
        
        for(int i=n-1;i>=0;i-=1)
        {
            if(nums[i] < nums[i+1])
            {
                index = i;
                break;
            }
        }

        System.out.println(index);

        if(index == -1)
        {
            reverse(nums,0,n);
            return;
        }

        for(int i=n;i>index;i-=1)
        {
            if(nums[i] > nums[index])
            {
                swap(nums,i,index);
                break;
            }
        }

        reverse(nums,index+1,n);

        return;
    }

    public void reverse(int [] nums,int i,int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i+=1;
            j-=1;
        }

        return;
    }

    public void swap(int [] nums,int i,int j)
    {
    
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}
