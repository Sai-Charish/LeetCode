class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = total;

        while(empty >= numExchange)
        {
            int fb = empty/numExchange ;
            empty = empty % numExchange;
            total += fb;
            empty += fb;
        }
        
        return total;
    }
}
