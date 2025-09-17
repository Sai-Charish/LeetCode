class Solution {
    public String reverseWords(String s) {
        
        String str;

        int left = 0;
        int right = s.length()-1;

        while(s.charAt(left) == ' ')
        {
            left+=1;
        }

        while(s.charAt(right) == ' ')
        {
            right-=1;
        }

        str = s.substring(left,right+1);


        StringBuilder res = new StringBuilder();

        int i=0;
        int j=0;

        while(j<str.length())
        {
            while(j<str.length() && str.charAt(j) != ' ')
            {
                j+=1;
            }
            
            if(res.length() == 0)
            {
                res.insert(0,str.substring(i,j));
            }
            else
            {
                res.insert(0,str.substring(i,j) + " ");
            }

            while(j<str.length() && str.charAt(j) == ' ')
            {
                j+=1;
            }
            i=j;
            
        }


        return res.toString();
        
    }
}
