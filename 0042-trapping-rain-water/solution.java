class Solution {
    public int trap(int[] arr) {
        int count =0;
        int i = 0;
        int j = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;

        while(i<j) {
            if(arr[i] <= arr[j])
            {
                if(leftMax > arr[i])
                {
                    count += leftMax - arr[i];
                }
                leftMax = Math.max(arr[i],leftMax);
                i+=1;
            }
            else
            {
                if(rightMax > arr[j]) {
                    count+= rightMax - arr[j];
                }
                rightMax = Math.max(arr[j],rightMax);
                j-=1;
            }
        }
        return count;
        
    }
}
