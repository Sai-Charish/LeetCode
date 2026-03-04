class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = max(nums);

        while(low <= high)
        {
            int mid = (low+high)/2;
            long var = func(nums,mid);

            if(var > threshold)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
    
    public int max(int [] arr)
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i+=1)
        {
            max = Math.max(arr[i],max);
        }
        return max;
    }

    public long func(int [] nums,int mid)
    {
        long ans = 0;

        for(int i=0;i<nums.length;i+=1)
        {
            int div = nums[i]/mid;
            int rem = nums[i]%mid;

            if(rem!=0)
            {
                ans = ans+div+1;
            }
            else
            {
                ans = ans+div;
            }
        }
        return ans;
    }
}
