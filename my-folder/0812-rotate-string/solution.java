class Solution {
    public boolean rotateString(String s, String goal) {
        String str1 = s+s;
        if(s.length() != goal.length())
        {
            return false;
        }

        return str1.contains(goal);

    }
}
