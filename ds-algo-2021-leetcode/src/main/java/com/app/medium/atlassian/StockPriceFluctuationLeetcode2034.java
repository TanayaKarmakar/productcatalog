package com.app.medium.atlassian;

import java.util.*;

public class StockPriceFluctuationLeetcode2034 {
    static class StockPrice {
        static class PriceItem {
            int timestamp;
            int price;

            public PriceItem(int timestamp, int price) {
                this.timestamp = timestamp;
                this.price = price;
            }
        }

        Map<Integer, PriceItem> stockPriceMap;
        PriorityQueue<PriceItem> maxPriceD;
        PriorityQueue<PriceItem> minPriceD;

        int latestTimeStamp;

        public StockPrice() {
            stockPriceMap = new HashMap<>();
            maxPriceD = new PriorityQueue<>((p1, p2) -> p2.price - p1.price);
            minPriceD = new PriorityQueue<>((p1, p2) -> p1.price - p2.price);
            latestTimeStamp = 0;
        }

        public void update(int timestamp, int price) {
            if(!stockPriceMap.containsKey(timestamp)) {
                PriceItem priceItem = new PriceItem(timestamp, price);
                stockPriceMap.put(timestamp, priceItem);
                minPriceD.add(priceItem);
                maxPriceD.add(priceItem);
            } else {
                PriceItem priceItem = stockPriceMap.get(timestamp);
                minPriceD.remove(priceItem);
                maxPriceD.remove(priceItem);
                priceItem.price = price;
                stockPriceMap.put(timestamp, priceItem);
                minPriceD.add(priceItem);
                maxPriceD.add(priceItem);
            }
            latestTimeStamp = Integer.max(latestTimeStamp, timestamp);
        }

        public int current() {
            return stockPriceMap.get(latestTimeStamp).price;
        }

        public int maximum() {
            return maxPriceD.peek().price;
        }

        public int minimum() {
            return minPriceD.peek().price;
        }
    }



    public static void main(String[] args) {

    }
}
