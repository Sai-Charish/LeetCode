class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int [] arr = {1,2,3,4,5,6,7,8,9};
        List<Integer> curr = new ArrayList<>();
        helper(arr,k,n,0,res,curr,0);
        return res;
    }

    public void helper(int [] arr,int len,int total,int sum,List<List<Integer>> res,List<Integer> curr,int start){
        if(curr.size() == len){
            if(sum == total){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if(start >= 9){
            return;
        }

        //include;
        curr.add(arr[start]);
        helper(arr,len,total,sum+arr[start],res,curr,start+1);
        curr.remove(curr.size()-1);

        //exclude;
        helper(arr,len,total,sum,res,curr,start+1);

        return;
    }
}
