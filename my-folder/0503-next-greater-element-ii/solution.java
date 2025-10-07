class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length-1;
        for(int i=n;i>=0;i-=1) {
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }
        int[] res = new int[n+1];
        for(int i=n;i>=0;i-=1){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            
            res[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
