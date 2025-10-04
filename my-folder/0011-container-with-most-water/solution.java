class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int maxTotal = 0;
        while(i<j) {
            int total = (j-i);
            if(height[i] <= height[j])
            {
                total *= height[i];
                i+=1;
            }
            else {
                total *= height[j];
                j-=1;
            }
            maxTotal = Math.max(total,maxTotal);

        }

        return maxTotal;
    }
}
