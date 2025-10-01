class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        Boolean sign = true;
        if(dividend < 0 && divisor > 0) sign = false;
        if(dividend > 0 && divisor < 0) sign = false;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long quotient = 0;
        // System.out.println(n);
        // System.out.println(d);

        while(n >= d)
        {
            
            int count=0;
            while(n >= (d << (count+1)))
            {
                count+=1;
            }

            quotient += (1L<<count);
            n-= (d<<count);
        }
        // System.out.println(quotient);

        
        if(quotient > Integer.MAX_VALUE && sign)  return Integer.MAX_VALUE;
        if(quotient > Integer.MAX_VALUE && !sign)  return Integer.MIN_VALUE; 

        return (!sign) ? (int) -quotient : (int)quotient;
    }
}
