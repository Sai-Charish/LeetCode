class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int max_len = 0;

        while(right < nums.length) {
            
            if(nums[right] == 0) {
                zeros+=1;
            }
            if(k < zeros) {
                if(nums[left] == 0){
                    zeros-=1;
                }
                left +=1;
            }
            if(zeros <= k) {
                int len = right - left +1;
                max_len = Math.max(max_len,len);
            }
            right+=1;
        }
        return max_len;
    }
}
