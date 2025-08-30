class Solution {
    public int missingNumber(int[] nums) {

        
        int n = nums.length - 1;
        int max = nums[0];

        boolean Zero_checker = false;

        int Curr_sum = 0;

        for(int i=0;i<=n;i+=1)
        {

            Curr_sum+=nums[i];
            max = Math.max(max,nums[i]);

            if(nums[i] == 0)
            {
                Zero_checker = true;
            }
        }

        int Actual_sum = (max*(max+1))/2;

        System.out.println(Actual_sum);
        System.out.println(Curr_sum);

        if(Actual_sum == Curr_sum && Zero_checker)
        {
            return max + 1;
        }
        else if(Actual_sum == Curr_sum)
        {
            return 0;
        }


        return Actual_sum - Curr_sum;

    }
}
