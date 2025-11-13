class Solution {
    public int[] findErrorNums(int[] nums) {
        int [] res = new int [2];
        
        long sum = 0;
        long sum_square = 0;
        
        int n = nums.length;
        
        long actual_sum = (long) n * (n+1) / 2;
        long actual_sum_square = (long) n*(n+1)*((2*n)+1)/6;
        
        for(int i=0;i<n;i+=1){
            sum += nums[i];
            sum_square += (nums[i] * nums[i]);
        }
        
        long var1 = actual_sum - sum;
        long var2 = actual_sum_square - sum_square;
        
        var2 = var2/var1;

        long x;
        long y;

        x = ((var2+var1)/2);

        y = (var2 - x);

        res[0] = (int)y;
        res[1] = (int)x;

        return res;
    }
}
