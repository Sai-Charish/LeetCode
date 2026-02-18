class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap <Integer,Integer> map = new HashMap<>();
        int [] res = new int [2];
        int diff = 0;
        for(int i=0;i<nums.length;i+=1)
        {
            diff = target - nums[i];
            if(map.containsKey(diff))
            {
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }

            map.put(nums[i],i);

        }

        return res;
       
    }
}