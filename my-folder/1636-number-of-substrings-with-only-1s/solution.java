class Solution {
    public int numSub(String s) {
        long count =0;
        int left = 0;
        int right = 0;

        int mod = 1000000000+7;

        while(right < s.length()){
            while(left < s.length() && s.charAt(left) == '0'){
                left +=1;
            }
            right = left;
            while(right < s.length() && s.charAt(right) == '1'){
                right +=1;
            }

            long len = right - left;
            count  += ((len * (len+1))/2)%mod;
            // count %= mod;
            left = right;
        }

        return (int) count % mod;
    }
}
