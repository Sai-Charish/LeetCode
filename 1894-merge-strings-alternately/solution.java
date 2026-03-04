

class Solution {
    public String mergeAlternately(String word1, String word2) {
        String temp = new String();
        int i=0;
        int j=0;
        while( i < word1.length() || j < word2.length())
        {
            if(i < word1.length())
            {
                temp = temp + word1.charAt(i);
                i+=1;
            }
            
            if(j < word2.length())
            {
                temp = temp + word2.charAt(j);
                j+=1;
            }
        }
        return  temp;
    }
}
