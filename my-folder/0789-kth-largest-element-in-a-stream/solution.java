class KthLargest {
    int k;
    int [] nums;
    int size = 0;

    PriorityQueue<Integer> que = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(int i=0;i<nums.length;i+=1){
            add(nums[i]);
        }
    }
    

    public int add(int val) {
        if(size<k){
            que.add(val);
            size+=1;
        }
        else if(que.peek() < val){
            que.poll();
            que.add(val);
            
        }

        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
