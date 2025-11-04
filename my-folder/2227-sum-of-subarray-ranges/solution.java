class Solution {
    public long subArrayRanges(int[] nums) {
        return subArraymax(nums) - subArraymin(nums);
    }

    public long subArraymin(int[] arr) {
        int n = arr.length;
        int [] pse = findPse(arr,n);
        int [] nse = findNse(arr,n);

        long ans = 0;
        for(int i=0;i<n;i+=1){
            long left = i - pse[i];
            long right = nse[i] - i;

            ans = ans + (long)arr[i] * left * right;
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


    public long subArraymax(int[] arr) {
        int n = arr.length;
        int [] pse = findPge(arr,n);
        int [] nse = findNge(arr,n);
        
        long ans = 0;
        for(int i=0;i<n;i+=1){
            long left = i - pse[i];
            long right = nse[i] - i;

            ans = ans + arr[i] * left * right;
        }

        return ans;
    }

    public int[] findPge(int [] arr,int n) {
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i+=1){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
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

    public int[] findNge(int [] arr,int n) {
        int [] res = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i-=1){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
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
