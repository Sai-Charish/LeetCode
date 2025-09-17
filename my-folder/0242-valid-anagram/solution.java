class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }

        int arr1[] = new int[26];

        for(int i=0;i<s.length();i+=1)
        {
            int val = s.charAt(i) - 'a';
            arr1[val]+=1;
        }

        for(int i=0;i<t.length();i+=1)
        {
            int val = t.charAt(i) - 'a';
            arr1[val]-=1;
        }

        for(int i=0;i<26;i+=1)
        {
            if(arr1[i] != 0)
            {
                return false;
            }
        }

        return true;
    }
}
