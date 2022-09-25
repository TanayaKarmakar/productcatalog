package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
class TravelInfo {
    private String stationName;
    private int time;

    public TravelInfo(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }

    public String getStationName() {
        return stationName;
    }

    public int getTime() {
        return time;
    }
}

class PassengerInfo {
    private int id;
    private TravelInfo checkIn;
    private TravelInfo checkout;

    public PassengerInfo(int id) {
        this.id = id;
    }

    public TravelInfo getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(TravelInfo checkIn) {
        this.checkIn = checkIn;
    }

    public TravelInfo getCheckout() {
        return checkout;
    }

    public void setCheckout(TravelInfo checkout) {
        this.checkout = checkout;
    }
}

class UndergroundSystem {
    Map<Integer, List<PassengerInfo>> passengerInfoMap;
    Map<String, List<Integer>> stationMap;

    public UndergroundSystem() {
        passengerInfoMap = new HashMap<>();
        stationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!passengerInfoMap.containsKey(id))
            passengerInfoMap.put(id, new ArrayList<>());
        TravelInfo travelInfo = new TravelInfo(stationName, t);
        PassengerInfo passengerInfo = new PassengerInfo(id);
        passengerInfo.setCheckIn(travelInfo);
        passengerInfoMap.get(id).add(passengerInfo);
    }

    public void checkOut(int id, String stationName, int t) {
        TravelInfo checkoutInfo = new TravelInfo(stationName, t);
        int size = passengerInfoMap.get(id).size();
        PassengerInfo lastInfo = passengerInfoMap.get(id).get(size - 1);
        lastInfo.setCheckout(checkoutInfo);
        String station = lastInfo.getCheckIn().getStationName() + ":"
                + lastInfo.getCheckout().getStationName();
        int diff = lastInfo.getCheckout().getTime() - lastInfo.getCheckIn().getTime();
        if(!stationMap.containsKey(station))
            stationMap.put(station, new ArrayList<>());
        stationMap.get(station).add(diff);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + ":" + endStation;
        List<Integer> history = stationMap.get(key);
        int sum = 0;
        for(Integer el: history) {
            sum += el;
        }
        return sum / (double) history.size();
    }
}


public class DesignUndergroundSystemLeetcode1396 {
    public static void main(String[] args) {

    }
}
