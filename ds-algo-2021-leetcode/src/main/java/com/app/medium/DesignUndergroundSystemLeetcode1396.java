package com.app.medium;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
class Passenger {
    public int id;
    public String startStation;
    public int time;
    public String endStation;

    public Passenger(int id, String startStation, int time) {
        this.id = id;
        this.startStation = startStation;
        this.time = time;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}

class UndergroundSystem {
    private Map<Integer, List<Passenger>> passengerMap;
    private Map<String, List<Integer>> stationMap;

    public UndergroundSystem() {
        passengerMap = new HashMap<>();
        stationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Passenger passenger = new Passenger(id, stationName, t);
        if(!passengerMap.containsKey(id)) {
            passengerMap.put(id, new ArrayList<>());
        }
        passengerMap.get(id).add(passenger);
    }

    public void checkOut(int id, String stationName, int t) {
        List<Passenger> passengers = passengerMap.get(id);
        Passenger lastTravel = passengers.get(passengers.size() - 1);
        lastTravel.setEndStation(stationName);
        lastTravel.time = (t - lastTravel.time);

        String path = lastTravel.startStation + ":" + lastTravel.endStation;
        if(!stationMap.containsKey(path))
            stationMap.put(path, new ArrayList<>());
        int prevSum = 0;
        if(!stationMap.get(path).isEmpty()) {
            prevSum = stationMap.get(path).get(stationMap.get(path).size() - 1);
        }
        prevSum += lastTravel.time;
        stationMap.get(path).add(prevSum);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + ":" + endStation;
        List<Integer> travelTimes = stationMap.get(key);
        return travelTimes.get(travelTimes.size() - 1) / (double)travelTimes.size();
    }
}



public class DesignUndergroundSystemLeetcode1396 {
    public static void main(String[] args) {

    }
}
