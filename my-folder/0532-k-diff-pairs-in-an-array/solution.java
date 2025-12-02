class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i+=1){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int count = 0;

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            int key = pair.getKey();
            if(k == 0){
                if(pair.getValue() > 1){
                    count+=1;
                }
            }
            else {
                if(map.containsKey(key+k)){
                    count+=1;
                }
            }
        }
        return count;
    }
}
