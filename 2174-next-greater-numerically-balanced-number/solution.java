class Solution {
    public int nextBeautifulNumber(int n) {
        while(n != n+1) {
            n+=1;
            if(isBeautiful(n)){
                return n;
            }
        }
        return 0;
    }

    public boolean isBeautiful(int n){
        int [] arr = new int [10];

        while(n>0){
            int digit = n%10;
            arr[digit] +=1;
            n/=10;
        }

        for(int i=0;i<10;i+=1){
            if(arr[i] != 0 && arr[i] != i){
                return false;
            }
        }
        return true;
    }
}
