def maxProfit(prices):
    maxProfitVal = 0
    prevProfit = 0
    
    for i in range(len(prices) - 1):
        prevProfit += max(0, prices[i + 1] - prices[i])
        maxProfitVal = max(maxProfitVal, prevProfit)

    return maxProfitVal

print(maxProfit([7,1,5,3,6,4]) == 7)
print(maxProfit([1,2,3,4,5]) == 4)
print(maxProfit([7,6,4,3,1]) == 0)
print(maxProfit([]) == 0)
print(maxProfit([1,5]) == 4)
print(maxProfit([5,1]) == 0)