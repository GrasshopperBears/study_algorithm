import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {
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