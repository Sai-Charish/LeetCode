class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(candidates,target,res,curr,0,0);
        return res;
    }

    public void helper(int [] candi,int tar,List<List<Integer>> res,List<Integer> curr,int start,int sum) {
        if(sum > tar) return ;

        if(sum == tar) {
            res.add(new ArrayList<>(curr));
            return;
        }

        //include
        for(int i=start;i<candi.length;i+=1) {
            if(i > start && candi[i] == candi[i-1]) continue;
            curr.add(candi[i]);
            helper(candi,tar,res,curr,i+1,sum+candi[i]);
            curr.remove(curr.size()-1);
        }
        
        return;

    }
}
