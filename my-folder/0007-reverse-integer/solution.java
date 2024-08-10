class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

       

        long res=0;
        int temp;
        int digit;
        temp = x;
        while(temp!=0)
        {
            digit = temp%10;
            res = (res*10)+digit;
            temp/=10;
        }
        
        if(res > max || res < min)
        {
            return 0;
        }

        return (int)res;
        
    }
}
