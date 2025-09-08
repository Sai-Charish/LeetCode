class Solution {
    public int maxProfit(int[] prices) {
        
        int max_profit = 0;
        int profit = 0;
        int mini = prices[0];
        int cost;

        for(int i=1;i<prices.length;i+=1)
        {
            profit = prices[i]-mini;
            max_profit = Math.max(profit,max_profit);
            mini = Math.min(mini,prices[i]); 
        }

        return max_profit;
    }
}
