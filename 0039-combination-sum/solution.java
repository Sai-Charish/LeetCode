class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(candidates,target,res,curr,0,0);
        return res;
    }

    public int helper(int[] candidates, int target,List<List<Integer>> res,List<Integer> curr,int start,int sum) {
        if(start >= candidates.length || sum > target) return 0;

        if(sum == target){
            res.add(new ArrayList<>(curr));
            return 0;
        }


        curr.add(candidates[start]);
        int include = helper(candidates,target,res,curr,start,sum+candidates[start]);
        curr.remove(curr.size()-1);

        int exclude = helper(candidates,target,res,curr,start+1,sum);

        return 0;
        
    }

}
