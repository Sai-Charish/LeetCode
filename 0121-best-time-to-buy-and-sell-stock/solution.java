class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int profit = 0;
        int mini_buy = prices[0];

        for(int i=0;i<prices.length;i+=1) {
            profit = prices[i] - mini_buy;
            max_profit = Math.max(max_profit , profit);
            mini_buy = Math.min(mini_buy , prices[i]);
        }
        return max_profit;
    }
}
