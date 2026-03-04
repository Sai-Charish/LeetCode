class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                low++;
                high++;
            }
            else if(ch == ')'){
                low--;
                high--;
            }
            else { // '*'
                low--;     // '*' as ')'
                high++;    // '*' as '('
            }

            if(high < 0) return false; // too many ')'
            if(low < 0) low = 0;       // reset lower bound
        }

        return low == 0;
    }
}

