package com.app.medium;


import java.util.Stack;

class StockSpanner {
    static class StockItem {
        int currentItem;
        int indx;

        public StockItem(int currentItem, int indx) {
            this.currentItem = currentItem;
            this.indx = indx;
        }
    }

    Stack<StockItem> stockItems;

    public StockSpanner() {
        stockItems = new Stack<>();
    }

    public int next(int price) {
        int value = 1;
        if(stockItems.isEmpty() || stockItems.peek().currentItem > price) {
            stockItems.push(new StockItem(price,  value));
        } else {
            while(!stockItems.isEmpty() && stockItems.peek().currentItem <= price) {
                StockItem si = stockItems.pop();
                value += si.indx;
            }

            stockItems.push(new StockItem(price, value));
        }
        return value;
    }
}
public class OnlineStockSpanLeetcode901 {
    public static void main(String[] args) {

    }
}
