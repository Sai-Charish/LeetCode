class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int min = nums.length/3;
        List<Integer> res = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i+=1){
            if(count1 == 0 && ele2 != nums[i]){
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 && ele1 != nums[i]) {
                count2 = 1;
                ele2 = nums[i];
            }

            else if(ele1 == nums[i]) count1+=1;
            else if(ele2 == nums[i]) count2+=1;
            else {
                count1-=1;
                count2-=1;
            }
        }

        count1 = 0;
        count2 = 0;
        System.out.println(ele1);
        System.out.println(ele2);

        for(int i=0;i<nums.length;i+=1){
            if(nums[i] == ele1){
                count1+=1;
            }
            else if(nums[i] == ele2){
                count2+=1;
            }
        }

        if(count1>min) res.add(ele1);
        if(count2>min) res.add(ele2);

        return res;
        
    }
}
