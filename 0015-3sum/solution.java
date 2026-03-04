class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i+=1)
        {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k-=1;
                }
                else if(sum < 0) {
                    j+=1;
                }
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j+=1;
                    k-=1;
                    while(j < k && nums[j] == nums[j-1]) j+=1;
                    while(j < k && nums[k] == nums[k+1]) k-=1;
                } 
            }
        }
        return res;
    }
}
