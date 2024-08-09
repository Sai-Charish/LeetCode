class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();

        int start = 0;
        int maxlength = 0;
        for(int i=0; i < s.length(); i+=1)
        {
            char cha = s.charAt(i);

            if(map.containsKey(cha) && map.get(cha) >= start)
            {
                start = map.get(cha)+1;
            }

            map.put(cha,i);

            maxlength = Math.max(maxlength,i-start+1);
        }


        return maxlength;
    }
}
