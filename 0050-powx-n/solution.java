class Solution {
    public double myPow(double x, int n) {
        long a = n;
        if(a<0) a = a*-1;
        double ans = helper(x,a);

        if(n<0) return 1/ans;
        return ans;
    }

    public double helper(double x,long n)
    {
        if(n == 0) return 1;

        double res = helper(x,n/2);

        if(n%2 == 0)
        {
            res = res * res;
        }
        else
        {
            res = res * res * x;
        }

        return res;

    }
}
