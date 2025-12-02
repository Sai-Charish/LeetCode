class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i+=1) {
            char ch = s.charAt(i);
            if(ch == '}' || ch == ')' || ch == ']'){
                 if(st.isEmpty()){
                    return false;
                }
                else{
                    char top = st.peek();
                    if(top == '(' && ch == ')'){
                        st.pop();
                    }
                    else if(top == '{' && ch == '}'){
                        st.pop();
                    }
                    else if(top == '[' && ch == ']'){
                        st.pop();
                    }
                    else {
                        st.push(ch);
                    }
                }
            }
            else {
                st.push(ch);
            }
            
           
        }
        return st.isEmpty();
    }
}
