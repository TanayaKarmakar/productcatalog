package com.app.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 16/03/22
 * @project ds-algo-2021
 */
class LogData {
    String identifier;
    String content;
    String fullText;

    public LogData(String identifier, String content, String fullText) {
        this.identifier = identifier;
        this.content = content;
        this.fullText = fullText;
    }
}

class LogDataComparator implements Comparator<LogData> {

    @Override
    public int compare(LogData o1, LogData o2) {
        int ans = o1.content.compareTo(o2.content);
        if(ans == 0) {
            return o1.identifier.compareTo(o2.identifier);
        }
        return ans;
    }
}

public class ReorderDataInLogFilesLeetcode937 {
    private static String[] reorderLogFiles(String[] logs) {
        List<LogData> letterLogs = new ArrayList<>();
        List<LogData> digitLogs = new ArrayList<>();

        for(String log: logs) {
            String []data = log.split("\\s+", 2);
            LogData logData = new LogData(data[0], data[1], log);
            if(Character.isDigit(data[1].charAt(0))) {
                digitLogs.add(logData);
            } else {
                letterLogs.add(logData);
            }
        }

        Collections.sort(letterLogs, new LogDataComparator());
        String[] output = new String[logs.length];
        int i = 0;
        for(LogData logData: letterLogs) {
            output[i++] = logData.fullText;
        }
        for(LogData logData: digitLogs) {
            output[i++] = logData.fullText;
        }
        return output;
    }

    public static void main(String[] args) {

    }
}
