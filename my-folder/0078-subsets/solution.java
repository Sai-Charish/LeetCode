class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(nums,0,res,part);
        return res;
    }

    public void helper(int[] nums,int start,List<List<Integer>> res,List<Integer> part) {
         res.add(new ArrayList<>(part));

        for(int i=start;i<nums.length;i+=1)
        {
            part.add(nums[i]);
            helper(nums,i+1,res,part);
            part.remove(part.size()-1);
        }

        return;

    }
}
