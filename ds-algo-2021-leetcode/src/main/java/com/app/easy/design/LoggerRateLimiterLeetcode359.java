package com.app.easy.design;


import java.util.HashMap;
import java.util.Map;

class Logger {
    static class LogItem {
        String message;
        int timeStamp;

        public LogItem(String message, int timeStamp) {
            this.message = message;
            this.timeStamp = timeStamp;
        }
    }

    Map<String, LogItem> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, new LogItem(message, timestamp + 10));
            return true;
        }
        LogItem item = map.get(message);
        if(item.timeStamp > timestamp)
            return false;
        item.timeStamp = timestamp + 10;
        map.put(message, item);
        return true;
    }
}


public class LoggerRateLimiterLeetcode359 {
    public static void main(String[] args) {

    }
}
