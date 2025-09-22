class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for(int i=0;i<s.length();i+=1)
        {
            char ch = s.charAt(i);
            if( ch =='(')
            {
                depth+=1;
            }
            else if(ch ==')')
            {
                if(depth != 0)
                {
                    max = Math.max(max,depth);
                    depth-=1;
                }
            }
        }

        return max;
        
    }
}
