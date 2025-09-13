class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);

        while(low<=high)
        {
            int mid = (low+high)/2;
            long speed = func(piles,mid);

            if(speed <= h)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }

    public int max (int [] arr)
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i+=1)
        {
            max = Math.max(max,arr[i]);
        } 

        return max;
    }

    public long func(int [] arr,int mid)
    {
        long ans = 0;
        for(int i=0;i<arr.length;i+=1)
        {
            int div = arr[i]/mid;
            int rem = arr[i]%mid;

            if(rem != 0)
            {
                ans = ans + div + 1; 
            }
            else
            {
                ans = ans + div;
            }
            
        }
        return ans;
    }
}
