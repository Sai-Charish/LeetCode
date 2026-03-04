class Solution {
    public int findPeakElement(int[] nums) {
        int low = 1;
        int high = nums.length-2;

        if(nums.length == 1)
        {
            return 0;
        }

        if(nums[low] < nums[low-1])
        {
            return low-1;
        }
        if(nums[high] < nums[high+1])
        {
            return high+1;
        }

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
            {
                return mid;
            }

            if(nums[mid] > nums[mid-1] && nums[mid]<nums[mid+1])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
}
