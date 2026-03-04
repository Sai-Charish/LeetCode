class Solution {
    public String longestCommonPrefix(String[] strs) {

        int min = strs[0].length();

        for(int i=1;i<strs.length;i+=1)
        {
            if(min > strs[i].length())
            {
                min = strs[i].length();
            }
        }

        for(int i=0;i<min;i+=1)
        {
            for(int j=1;j<strs.length;j+=1)
            {
                if(strs[j].charAt(i) != strs[j-1].charAt(i))
                {
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0].substring(0,min);

    }
}
