class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int [] pse = findPse(arr,n);
        int [] nse = findNse(arr,n);

        int mod = 1000000007;

        int ans = 0;
        for(int i=0;i<n;i+=1){
            int left = i - pse[i];
            int right = nse[i] - i;

            ans = (ans + (int)(((long)arr[i] * left%mod * right%mod)% mod)) %mod;
        }

        return ans;
    }

    public int[] findPse(int [] arr,int n) {
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i+=1){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }
            st.push(i);
        }

        return res;
    }

    public int[] findNse(int [] arr,int n) {
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i-=1){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = n;
            }
            else {
                res[i] = st.peek();
            }
            st.push(i);
        }

        return res;

    }
}
