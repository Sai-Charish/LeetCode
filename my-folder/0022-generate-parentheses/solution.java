class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(str,n,0,0,res);
        return res;
    }

    public void helper(StringBuilder str,int n,int open,int close,List<String> res) {
        if(open == n && close == n) {
            res.add(str.toString());
            return ;
        }

        if(open < n)
        {
            str.append('(');
            helper(str,n,open+1,close,res);
            str.deleteCharAt(open+close);
        }

        if(close < open)
        {
            str.append(')');
            helper(str,n,open,close+1,res);
            str.deleteCharAt(open+close);
        }

        return;
    }
}
