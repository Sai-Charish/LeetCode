class Solution {
    public int countGoodNumbers(long n) {
        long even;
        long odd;
        long mod = 1000000007;
        if(n%2==0){
            even = n/2;
            odd = n/2;
        }
        else{
            even = (n/2) + 1;
            odd = n/2;
        }

        //ans = 5^even * 4^odd;
        long a = pow(5,even,mod);
        long b = pow(4,odd,mod);

        long ans = (a*b)%mod;
        System.out.println(ans);

        return (int)(ans);


    }

    public long pow(long x,long n,long mod)
    {
        if(n == 0) return 1;
        long res = pow(x,n/2,mod);
        if(n%2 == 1)
        {
            res = res * res * x;
        }
        else
        {
            res = res * res;
        }
        res = res % mod;
        return res;
    }
}
