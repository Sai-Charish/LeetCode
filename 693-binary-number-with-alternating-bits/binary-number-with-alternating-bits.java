class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = getBinary(n);
        System.out.println(binary);

        for(int i=1;i<binary.length();i+=1){
            if(binary.charAt(i-1) == binary.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public String getBinary(int n){
        StringBuilder res = new StringBuilder();
        while(n > 0){
            int bit = n%2;
            res = res.append(bit +"");
            n = n/2;
        }
        return res.toString();

    }
}