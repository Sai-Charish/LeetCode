class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int weak = 0;

        for(int i=n ; i>0 ; i=i-7,weak+=1){
            if(i >= 7){
                total += 28 + (weak * 7);
            }
            else {
                int sum = (i * (i+1))/2;
                total += sum + (weak * i);
            }
        }

        return total;
        
    }
}
