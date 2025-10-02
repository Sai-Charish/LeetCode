class Solution {
    public int countPrimes(int n) {
        if(n == 1 || n==0) return 0;
        boolean[] prime = new boolean[n+1];
        // for(boolean i : prime) System.out.println(i);
        SieveOfE(n, prime);
        int count = 0;

        for(int i=1;i<n;i+=1){
            if(!prime[i]) {
                count+=1;
            }
        }

        return count;

    }

    public void SieveOfE(int n, boolean[] prime) {
        prime[1] = true;

        for (int i = 2; i*i < n; i += 1) {
            if (!prime[i]) {
                for (int j = (i*i); j < n; j+=i) {
                    prime[j] = true;
                }
            }
        }

        return;
    }
}
