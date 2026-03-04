class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length-1;
        int actualSum = (n * (n+1))/2;

        int currSum = 0;
        int max = 0;
        for(int i : nums){
            currSum += i;
            max = Math.max(max,i);
        }
        if(max == n){
            return max+1;
        }
        return Math.abs(actualSum - currSum + max);
    }
}
