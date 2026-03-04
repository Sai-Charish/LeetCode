class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i+=1)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return helper(sb.toString(),0,sb.length()-1);
    }

    public boolean helper(String s,int start, int end)
    {
        if(start >= end) return true;

        if(s.charAt(start) != s.charAt(end)) return false;

        return helper(s,start+1,end-1);

    }
}
