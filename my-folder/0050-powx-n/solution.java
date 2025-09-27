class Solution {
    public double myPow(double x, int n) {
        if(x == 1) return x;
        double res = 1;
        Boolean negitive = (n<0) ? true : false;

        long a = (negitive) ? -(long)n : n;
        System.out.println(a);

        while(a > 0)
        {
            if(a%2 == 1)
            {
                res = res*x;
            }
            x = x * x;
            a = a/2;
        }

        return (negitive) ? 1/res : res; 
    }
}
