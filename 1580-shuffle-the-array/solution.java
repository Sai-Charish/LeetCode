class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] res = new int [nums.length];

        int i=0;
        while(i<n){
            res[2*i] = nums[i];
            res[(2*i)+1] = nums[n+i];
            i+=1;
        }
        return res;
    }
}
