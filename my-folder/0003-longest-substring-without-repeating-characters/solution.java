class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max_len = 0;
        int lenght = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch,right);
            }
            else{
                left = Math.max(left,map.get(ch)+1);
                map.put(ch,right);
            }

            lenght = right - left + 1 ;
            max_len = Math.max(max_len,lenght); 

            right+=1;
        }

        return max_len;
    }
}
