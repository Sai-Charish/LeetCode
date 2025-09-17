class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> stk = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(int i=0;i<s.length();i+=1)
        {
            if(stk.empty())
            {
                if(s.charAt(i) == '('){
                    stk.push(s.charAt(i));
                }
            }
            else
            {
                if(s.charAt(i) == '(')
                {   
                    stk.push(s.charAt(i));
                }
                else
                {
                    stk.pop();
                    if(stk.empty())
                    {
                        continue;
                    }
                }
                str.append(s.charAt(i));
            }
        }
        return str.toString();
        
    }
}
