class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] n = nse(heights);
        int [] p = pse(heights);

        int max = 0;
        for(int i=0;i<heights.length;i+=1) {
            int area = heights[i] * (n[i] - p[i] - 1);
            max = Math.max(area,max); 
        }

        return max;
    }

    public int [] pse(int [] arr) {
        Stack <Integer> st = new Stack<>();
        int [] res = new int [arr.length];

        for(int i=0;i<arr.length;i+=1){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    public int [] nse(int [] arr) {
        Stack <Integer> st = new Stack<>();
        int [] res = new int [arr.length];

        for(int i=arr.length-1;i>=0;i-=1){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=arr.length;
            }
            else{
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

}
