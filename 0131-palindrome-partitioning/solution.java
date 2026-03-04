class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s,s.length(),res,curr,0);
        return res;
    }

    public void helper(String s,int n,List<List<String>> res,List<String> curr,int start) {
        if(start == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<n;i+=1){
            if(isPalindrome(s,start,i)){
                curr.add(s.substring(start,i+1));
                helper(s,n,res,curr,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str,int start,int end) {
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}
