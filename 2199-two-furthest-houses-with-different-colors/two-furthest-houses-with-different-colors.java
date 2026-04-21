class Solution {
    public int maxDistance(int[] colors) {
        int res = 0;
        int n = colors.length;

        for(int i=0;i<n;i+=1){
            for(int j=i+1;j<n;j+=1){
                if(colors[i] != colors[j] && (j-i) > res){
                    res = j-i;
                }
            }
        }
        return res;
    }
}