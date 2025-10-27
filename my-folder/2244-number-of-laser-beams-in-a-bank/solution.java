class Solution {
    public int numberOfBeams(String[] bank) {
        int intial = 0;
        int count = 0;

        for(int i=0;i<bank.length;i+=1){
            int ones = countOnes(bank[i]);
            if(ones == 0) continue;
            count = (intial*ones) + count;
            intial = ones;
        }
        return count;
    }

    public int countOnes(String str){
        int res = 0;
        for(int i=0;i<str.length();i+=1){
            if(str.charAt(i) == '1'){
                res+=1;
            }
        }
        return res;
    }
}
