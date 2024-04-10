class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        buy_price = prices[0]
        for i in prices:
            if(i < buy_price):
                buy_price = i
            else:
                current_profit =i - buy_price  
                profit = max(profit , current_profit)
            

        return profit
