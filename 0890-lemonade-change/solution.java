class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        // int twentys = 0;

        for(int i=0 ;i < bills.length;i+=1){
            if(bills[i] == 5){
                fives +=1;
            }
            else if(bills[i] == 10){
                if(fives > 0){
                    fives-=1;
                    tens +=1;
                }
                else {
                    return false;
                }
            }
            else {
                if(fives > 0 && tens > 0){
                    tens -=1;
                    fives -=1;
                }
                else if(fives >= 3){
                    fives -=3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
