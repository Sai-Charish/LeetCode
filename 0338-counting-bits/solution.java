class Solution {
    public int[] countBits(int n) {
        int [] res = new int [n+1];

        for(int i=0;i<=n;i+=1){
            res[i] = count1s(i);
        }
        return res;
    }

    public int count1s(int num){
        int count = 0;
        while(num !=0){
            if((num&1) != 0) {
                count +=1;
            }
            num = num>>1;
        }
        return count;
    }
}
