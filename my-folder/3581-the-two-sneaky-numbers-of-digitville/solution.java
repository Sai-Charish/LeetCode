class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int [] arr = new int [2];
        int index = 0;

        for(int i=0;i<nums.length;i+=1){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                arr[index] = nums[i];
                index+=1;
            }
        }
        return arr;
    }
}
