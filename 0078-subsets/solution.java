class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    //     <-- Recurrsive pattern -->  
    //     List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> part = new ArrayList<>();
    //     helper(nums,0,res,part);
    //     return res;
    // }

    // public void helper(int[] nums,int start,List<List<Integer>> res,List<Integer> part) {
    //      res.add(new ArrayList<>(part));

    //     for(int i=start;i<nums.length;i+=1)
    //     {
    //         part.add(nums[i]);
    //         helper(nums,i+1,res,part);
    //         part.remove(part.lastIndexOf(nums[i]));
    //     }

    //     return;

    // }


        // Bitwise operator

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        n = (1 << n);

        for(int i=0;i<n;i+=1)
        {
            List<Integer> part = new ArrayList<>();
            int count = 0;
            while(i >= (1 << count)){
                if((i & (1 << count)) != 0)
                {
                    part.add(nums[count]);
                }
                count +=1;
            }
            res.add(part);
        }

        return res;
    }
}
