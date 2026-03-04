class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count =0;
        int curr = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i+=1) {
            int low = nums[i] - k;
            int high = nums[i] + k;

            if(curr+1 <= high){
                int res = Math.max(curr+1,low);
                curr = res;
                count +=1;
            }
        }
        return count;
    }
}
