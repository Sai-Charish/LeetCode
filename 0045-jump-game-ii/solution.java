class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int jumps = 0;
        while(right < n-1){
            int far = 0;
            for(int i=left ;i<=right;i+=1){
                far = Math.max(far,nums[i]+i);
            }
            left = right + 1;
            right = far;
            jumps +=1;
        }
        return jumps;
    }
}
