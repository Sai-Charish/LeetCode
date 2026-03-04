class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<num.length();i+=1){
            while(!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)){
                st.pop();
                k-=1;
            }
            st.push(num.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        while(k > 0) {
            st.pop();
            k-=1;
        }


        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }

        int start = 0;
        int end = res.length();

        while(start < end && res.charAt(start) == '0') {
            start+=1;
        }

                
        String str = res.substring(start);

        return (str.isEmpty()) ? "0" : str ;
    }
}
