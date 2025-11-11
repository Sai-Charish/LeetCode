class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for(int i=0;i<nums.length;i+=1){
            int sum = 0;
            for(int j=i;j<nums.length;j+=1) {
                sum += nums[j];
                if(sum == goal) {
                    count+=1;
                }
            }
        }

        return count;
    }
}
