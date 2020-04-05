def maxProfit(prices):
    if not len(prices) or len(prices) == 1:
        return 0

    n = len(prices)
    if n == 2:
        return max(0, prices[1] - prices[0])

    maxProfitVal = 0
    prevProfit = 0
    
    for i in range(n - 1):
        currentPrice = prevProfit + max(0, prices[i + 1] - prices[i])
        prevProfit = currentPrice
        maxProfitVal = max(maxProfitVal, prevProfit)

    return maxProfitVal

print(maxProfit([7,1,5,3,6,4]) == 7)
print(maxProfit([1,2,3,4,5]) == 4)
print(maxProfit([7,6,4,3,1]) == 0)