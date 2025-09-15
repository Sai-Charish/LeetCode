class Solution {
    public int splitArray(int[] nums, int k) {
        
        int [] temp = new int[2];
        temp = maxsum(nums);

        int low =  temp[0];
        int high = temp[1];

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(func(nums,mid) <=k )
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return low;
    }

    public int func(int [] arr, int mid)
    {
        int sum = 0;
        int count = 1;

        for(int i=0;i<arr.length;i+=1)
        {
            sum+=arr[i];
            if(sum > mid)
            {
                count+=1;
                sum = arr[i];
            }
        }

        return count;
    }

    public int[] maxsum(int[] arr)
    {
        int [] res = new int [2];
        int sum = arr[0];
        int max = arr[0];

        for(int i=1;i<arr.length;i+=1)
        {
            sum+=arr[i];
            max = Math.max(arr[i],max);
        }

        res[0] = max;
        res[1] = sum;

        return res;
    } 
}
