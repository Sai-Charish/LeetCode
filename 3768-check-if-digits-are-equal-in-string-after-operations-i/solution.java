class Solution {
    public boolean hasSameDigits(String s) {
        int len = s.length();
        while(len != 2){
            StringBuilder str = new StringBuilder();
            for(int i=1;i<s.length();i+=1){
                int a = s.charAt(i)-'0';
                int b = s.charAt(i-1)-'0';
                int sum = ((s.charAt(i)-'0')+(s.charAt(i-1)-'0'))%10;
                str.append(sum);
            }
            s = str.toString();
            len = s.length();
        }

        if(s.charAt(0) == s.charAt(1)){
            return true;
        }
        return false;
    }
}
