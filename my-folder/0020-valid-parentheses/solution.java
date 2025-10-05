class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i+=1) {
            char ch = s.charAt(i);

            if(st.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                return  false;
            }

            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);

            else{
                char top = st.peek();
                if(top == '(' && ch == ')') {
                    st.pop();
                }
                else if(top == '{' && ch == '}') {
                    st.pop();
                }
                else if(top == '[' && ch == ']') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();
        
    }
}
