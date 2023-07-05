package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 19/06/23
 * @project ds-algo-2021-leetcode
 */
public class ReorderDataInLogsFileLeetcode937 {
  static class LogItem {
    private String logId;
    private String content;
    private String fullText;

    public LogItem(String logId, String content, String fullText) {
      this.logId = logId;
      this.content = content;
      this.fullText = fullText;
    }
  }

  static class LetterLogsComparator implements Comparator<LogItem> {

    @Override
    public int compare(LogItem o1, LogItem o2) {
      int ans = o1.content.compareTo(o2.content);
      if(ans == 0)
        return o1.logId.compareTo(o2.logId);
      return ans;
    }
  }

  private static String[] reorderLogFiles(String[] logs) {
    List<LogItem> digitLogs = new ArrayList<>();
    List<LogItem> letterLogs = new ArrayList<>();

    for(String log: logs) {
      String[] tokens = log.split("\\s+", 2);
      String logId = tokens[0];
      String content = tokens[1];
      LogItem logItem = new LogItem(logId, content, log);
      if(isDigit(content)) {
        digitLogs.add(logItem);
      } else {
        letterLogs.add(logItem);
      }
    }

    Collections.sort(letterLogs, new LetterLogsComparator());
    letterLogs.addAll(digitLogs);
    String[] ans = new String[logs.length];
    int i = 0;
    for(LogItem currentItem: letterLogs) {
      ans[i++] = currentItem.fullText;
    }
    return ans;
  }

  private static boolean isDigit(String content) {
    String[] tokens = content.split("\\s+");
    try {
      Integer.parseInt(tokens[0].charAt(0) + "");
      return true;
    } catch (NumberFormatException numberFormatException) {
      return false;
    }
  }

  public static void main(String[] args) {

  }
}
