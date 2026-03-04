class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int [] range = max(bloomDay);
        int low = range[1];
        int high = range[0];
        int ans = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(possible(bloomDay,m,k,mid))
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

            
        }

        return ans;
    }

    public boolean possible(int [] arr,int m,int k,int mid)
    {
        int count = 0;
        int No_of_B = 0;
        for(int i=0;i<arr.length;i+=1)
        {
            if(arr[i]<=mid)
            {
                count+=1;
            }
            else
            {
                No_of_B += count/k;
                count = 0;
            }
        }

        No_of_B += count/k;

        if(No_of_B >= m)
        {
            return true;
        }
        
        return false;

    }

    public int [] max(int [] arr)
    {
        int [] max = new int [2];
        max[0] = arr[0];
        max[1] = arr[1];

        for(int i=0;i<arr.length;i+=1)
        {
            if(arr[i] > max[0])
            {
                max[0] = arr[i];
            }
            if(arr[i] < max[1])
            {
                max[1] = arr[i];
            }
        }
        return max;
    }
}
