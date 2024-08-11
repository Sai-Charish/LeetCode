class Solution {
    public int maxArea(int[] height) {
        int res=0;
        int low;
        int high;
        int size = height.length;
        int curres;

        low = 0;
        high = size-1;

        while(low < high )
        {
            curres = (Math.min(height[high],height[low])) * (high-low);
            res = Math.max(res,curres);
            if(height[low] > height[high])
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        return res;
    }
}
