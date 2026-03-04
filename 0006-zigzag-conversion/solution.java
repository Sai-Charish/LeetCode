class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        char ch;

       String res="";
       int inc;
       for(int i = 0; i < numRows;i+=1)
       {
            inc = (numRows-1)*2;
            for(int j = i ; j < s.length() ; j += inc)
            {
                ch = s.charAt(j);
                res += ch;
                if( i > 0 && i < numRows-1 && j + inc - 2 * i < s.length())
                {
                    ch = s.charAt(j + inc - 2 * i);
                    res += ch;
                }
            }
       }
       return res;
    }
}
