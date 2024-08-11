class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }

        int temp;
        int res = 0;
        int digit;
    
        temp = x;
        while(temp!=0)
        {
            digit = temp%10;
            res = (res*10) + digit;
            temp/=10;
        }

        if(res == x)
        {
            return true;
        }
        return false;
    }
}
