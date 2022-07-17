import java.util.HashMap;
import java.util.TreeMap;

class StockPrice {
    int recent = 0;
    HashMap<Integer, Integer> priceInfo;
    TreeMap<Integer, Integer> priceCount;

    public StockPrice() {
        priceInfo = new HashMap<>();
        priceCount = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (recent < timestamp) recent = timestamp;
        if (priceInfo.containsKey(timestamp)) {
            int prevPrice = priceInfo.get(timestamp);
            int prevPriceCount = priceCount.get(prevPrice);
            if (prevPriceCount == 1) {
                priceCount.remove(prevPrice);
            } else {
                priceCount.put(prevPrice, prevPriceCount - 1);
            }
        }
        priceInfo.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return priceInfo.get(recent);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}

class Leet2034 {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}
