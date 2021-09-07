def helper(stock, arr, profit):
    if len(arr) == 1:
        if stock < 0 or arr[0] <= stock:
            return profit
        return profit + arr[0] - stock
    if stock < 0:
        return max(helper(arr[0], arr[1:], profit), helper(-1, arr[1:], profit))
    if arr[0] <= stock:
        return helper(stock, arr[1:], profit)
    return max(helper(-1, arr[1:], profit + arr[0] - stock), helper(stock, arr[1:], profit))


def maxProfit(prices):
    return helper(-1, prices, 0)


print(maxProfit([7,1,5,3,6,4]))
