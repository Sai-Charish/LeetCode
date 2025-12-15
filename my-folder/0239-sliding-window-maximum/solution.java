class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int [n-k+1];

        Deque<Integer> dque = new ArrayDeque<>();

        for(int i=0;i<n;i+=1){
            if(!dque.isEmpty() && dque.getFirst() <= i-k){
                dque.pollFirst();
            }

            while(!dque.isEmpty() && nums[dque.getLast()] < nums[i]){
                dque.pollLast();
            }
            
            dque.addLast(i);
            if(i >= k-1){
                res[i-k+1] = nums[dque.getFirst()];
            }
        }

        return res;
    }
}
