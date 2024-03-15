package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, CustomerInfo> passengerMap;
    private Map<String, List<Double>> travelTimeMap;

    static class CustomerInfo {
        int id;
        String stationName;
        int timestamp;

        public CustomerInfo(int id, String stationName, int timestamp) {
            this.id = id;
            this.stationName = stationName;
            this.timestamp = timestamp;
        }
    }

    public UndergroundSystem() {
        passengerMap= new HashMap<>();
        travelTimeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!passengerMap.containsKey(id)) {
            passengerMap.put(id, new CustomerInfo(id, stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(!passengerMap.containsKey(id))
            return;
        CustomerInfo checkdInInfo = passengerMap.get(id);
        String fromToStation = checkdInInfo.stationName + ":" + stationName;
        if(!travelTimeMap.containsKey(fromToStation))
            travelTimeMap.put(fromToStation, new ArrayList<>());
        double timeDiff = t - checkdInInfo.timestamp;
        travelTimeMap.get(fromToStation).add(timeDiff);
        passengerMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String fromToStation = startStation + ":" + endStation;
        if(!travelTimeMap.containsKey(fromToStation))
            return 0;
        List<Double> times = travelTimeMap.get(fromToStation);
        double sum = 0;
        for(double time: times) {
            sum += time;
        }
        return sum / times.size();
    }
}

public class DesignUndergroundSystemLeetcode1936 {
    public static void main(String[] args) {

    }
}
