class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
        {
            return false;
        }

        int temp = x;
        int digit;
        long res = 0;

        while(temp > 0)
        {
            digit = temp%10;
            res = (res*10) + digit;
            temp = temp/10;
        }

        System.out.println(res);
    
        return (x == (int) res) ? true : false;   
    }
}