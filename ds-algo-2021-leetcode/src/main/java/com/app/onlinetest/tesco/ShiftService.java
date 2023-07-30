package com.app.onlinetest.tesco;

import static com.app.onlinetest.tesco.TimeUtil.convertToMinutes;
import static com.app.onlinetest.tesco.TimeUtil.convertToTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class ShiftService {
  static class Time {
    int hour;
    int minute;

    public Time(int hour, int minute) {
      this.hour = hour;
      this.minute = minute;
    }

    public String toString() {
      return "{hh: " + hour + ",mm:" + minute + "}";
    }
  }

  static class ShiftTiming {
    Time startTime;
    Time endTime;

    public ShiftTiming(Time startTime, Time endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public String toString() {
      return "{" + startTime + "," + endTime + "}";
    }

  }



  public static List<ShiftTiming> showShifts(List<ShiftTiming> shiftTimings) {
    if(shiftTimings.isEmpty())
      return new ArrayList<>();

    Collections.sort(shiftTimings, (s1, s2) -> convertToMinutes(s1.startTime) - convertToMinutes(s2.startTime));

    List<ShiftTiming> resultShiftTimings = new ArrayList<>();
    int prevStartTime = convertToMinutes(shiftTimings.get(0).startTime);
    int prevEndTime = convertToMinutes(shiftTimings.get(0).endTime);

    for(int pos = 1; pos < shiftTimings.size(); pos++) {
      ShiftTiming currentShiftTiming = shiftTimings.get(pos);
      if(convertToMinutes(currentShiftTiming.startTime) <= prevEndTime) {
        prevEndTime = convertToMinutes(currentShiftTiming.endTime);
      } else {
        resultShiftTimings.add(new ShiftTiming(TimeUtil.convertToTime(prevStartTime), TimeUtil.convertToTime(prevEndTime)));
        prevStartTime = convertToMinutes(currentShiftTiming.startTime);
        prevEndTime = convertToMinutes(currentShiftTiming.endTime);
      }
    }

    if(resultShiftTimings.isEmpty()) {
      resultShiftTimings.add(new ShiftTiming(TimeUtil.convertToTime(prevStartTime),
          TimeUtil.convertToTime(prevEndTime)));
    } else {
      ShiftTiming lastShiftTiming = resultShiftTimings.get(resultShiftTimings.size() - 1);
      if(convertToMinutes(lastShiftTiming.startTime) != prevStartTime && convertToMinutes(lastShiftTiming.endTime) != prevEndTime) {
        resultShiftTimings.add(new ShiftTiming(convertToTime(prevStartTime), convertToTime(prevEndTime)));
      }
    }
    return resultShiftTimings;
  }



  public static void main(String[] args) {
    List<ShiftTiming> inputShiftTiming = new ArrayList<>();
    inputShiftTiming.add(new ShiftTiming(new Time(8, 10), new Time(10, 10)));
    inputShiftTiming.add(new ShiftTiming(new Time(10, 10),new Time(12, 00)));
    inputShiftTiming.add(new ShiftTiming(new Time(14,30),new Time(19, 10)));

    List<ShiftTiming> resultShiftTiming = showShifts(inputShiftTiming);

    System.out.println("TC1" + resultShiftTiming);


    inputShiftTiming = new ArrayList<>();
    inputShiftTiming.add(new ShiftTiming(new Time(8, 10), new Time(10, 10)));
    //inputShiftTiming.add(new ShiftTiming(14,12));
    inputShiftTiming.add(new ShiftTiming(new Time(14, 30),new Time(19, 10)));

    resultShiftTiming = showShifts(inputShiftTiming);

    System.out.println("TC2" + resultShiftTiming);

    inputShiftTiming = new ArrayList<>();
    resultShiftTiming = showShifts(inputShiftTiming);

    System.out.println("TC3" + resultShiftTiming);

  }
}
