class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=1;

        while(j<nums.length){
            while(i<nums.length && nums[i]!=0){
                i+=1;
            }

            if(i>=nums.length)
            {
                break;
            }
            j = i+1;
            while(j<nums.length && nums[j]==0){
                j+=1;
            }

            if(j < nums.length)
            {int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;}
        }
    }
}
