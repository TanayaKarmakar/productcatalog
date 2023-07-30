package com.app.onlinetest.tesco;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class TimeUtil {
  public static int convertToMinutes(ShiftService.Time time) {
    return time.hour * 60 + time.minute;
  }

  public static ShiftService.Time convertToTime(int minutes) {
    int hour = minutes / 60;
    minutes = minutes % 60;
    return new ShiftService.Time(hour, minutes);
  }
}
