class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int i=0;
        int j=0;

        while(i < g.length && j < s.length) {
            if(g[i] <= s[j]){
                res +=1;
                i+=1;
                j+=1;
            }
            else {
                j+=1;
            }
        }

        return res;
    }
}
