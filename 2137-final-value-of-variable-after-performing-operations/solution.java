class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int sum = 0;
        for(int i=0;i<operations.length;i+=1){
            sum += value(operations[i]);
        }

        return sum;
    }

    public int value(String str){
        int x = 1;
        return (str.charAt(1) == '-') ? -1 : 1;
    }
}
