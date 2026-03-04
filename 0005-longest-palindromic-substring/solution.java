class Solution {
    public String longestPalindrome(String s) {
        String Palindrome;
        String LongestPalin="";
        int high;
        int low;

        if(s.length()==1)
        {
            return s;
        }

        for(int i=0;i<s.length();i+=1)
        {
            //odd cases
            low = i;
            high = i;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high))
            {
                low -=1;
                high +=1;
            }

            Palindrome = s.substring(low+1,high);

            if(Palindrome.length() > LongestPalin.length())
            {
                LongestPalin = Palindrome;
            }

            //even cases

            low = i-1;
            high = i;
            while (low  >= 0 && high < s.length() && s.charAt(low) == s.charAt(high))
            {
                low -=1;
                high += 1;
            }

            Palindrome = s.substring(low+1,high);

            if(Palindrome.length() > LongestPalin.length())
            {
                LongestPalin = Palindrome;
            }

        }
        return LongestPalin;
    }
}
