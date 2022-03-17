package com.app.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
class LogData1 {
    String msg;
    long timeStamp;

    public LogData1(String msg, long timeStamp) {
        this.msg = msg;
        this.timeStamp = timeStamp;
    }
}

class Logger {
    Map<String, LogData1> logData1Map;

    public Logger() {
        logData1Map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logData1Map.containsKey(message)) {
            LogData1 logData1 = new LogData1(message, timestamp);
            logData1Map.put(message, logData1);
            return true;
        }
        LogData1 logData1 = logData1Map.get(message);
        if(logData1.timeStamp + 10 > timestamp)
            return false;
        logData1.timeStamp = timestamp;
        logData1Map.put(message, logData1);
        return true;
    }
}

public class LoggerRateLimiterLeetcode359 {
    public static void main(String[] args) {

    }
}
