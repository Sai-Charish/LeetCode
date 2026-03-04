class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);

        // System.out.println("low " + low);
        // System.out.println("high " + high);
        
        while(low <=high)
        {
            int mid = (low+high)/2;

            if(func(weights,days,mid))
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
            // System.out.println("low " + low);
            // System.out.println("high " + high);
        }
        return low;
    }

    public boolean func(int [] arr,int days,int capacity)
    {
        int no_of_d = 0;
        long sum = 0;
        for(int i=0;i<arr.length;i+=1)
        {
            sum+=arr[i];
            if(sum > capacity)
            {
                no_of_d +=1;
                sum = arr[i];
            }
        }

        no_of_d +=1;

        if(no_of_d <= days)
        {
            return true;
        }

        return false;

    }

    public int max(int [] arr)
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i+=1)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }
        }
        return max;
    }

    public int sum(int [] arr)
    {
        int res = 0;
        for(int i=0;i<arr.length;i+=1)
        {
            res+=arr[i];
        }
        return res;
    }
}
