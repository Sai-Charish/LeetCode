class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> pque = new PriorityQueue<>();

        for(int i=0;i<nums.length;i+=1){
            pque.add(nums[i]);

            if(pque.size() > k){
                pque.poll();
            }
        }

        return pque.peek();
    }
}
