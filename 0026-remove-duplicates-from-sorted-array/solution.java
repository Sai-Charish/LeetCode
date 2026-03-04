class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=1;

        while(j<n)
        {
            while(j<n && nums[i]==nums[j])
            {
                j+=1;
            }
            if(j==n)
            {
                break;
            }

            nums[i+1]=nums[j];
            i+=1;

        }

        return i+1;

    }
}
