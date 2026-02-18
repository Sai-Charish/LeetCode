class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int i=0;
        boolean positive = true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        while(i<s.length() && s.charAt(i) ==' ')
        {
            i+=1;
        }
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
        {
            if(s.charAt(i) == '-')
            {
                positive = false;
            }
            i+=1;
        }

        while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9'))
        {
            int val = s.charAt(i) - '0';
            res = (res*10) + val;
            if(res > max || res < min)
            {
                break;
            }
            i+=1;
        }

        if(!positive)
        {
            res = res * -1;
        }

        if(res > max)
        {
            return max;
        }
        if(res < min)
        {
            return min;
        }
        
        return (int) res;


    }
}