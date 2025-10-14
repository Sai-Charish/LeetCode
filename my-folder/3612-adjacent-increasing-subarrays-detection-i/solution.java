class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int cl = 1;
        int pl = 0;
        int res = 0;

        for(int i=1;i<nums.size();i+=1) {
            if(nums.get(i) > nums.get(i-1)){
                cl +=1;
            }
            else {
                pl = cl;
                cl = 1;
            }

            res = Math.max(res,Math.max(cl/2,Math.min(pl,cl)));
        }
        return res >= k;
    }
}
