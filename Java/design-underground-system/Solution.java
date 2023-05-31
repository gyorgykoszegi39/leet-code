import java.util.HashMap;

class CheckIn {
    public String stationName;
    public int time;

    public CheckIn(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}

class Detail {
    public double travelTime = 0;
    public int countTravels = 0;
}
class UndergroundSystem {

    private HashMap<String, Detail> travelTimes;
    private HashMap<Integer, CheckIn> passangers;
    public UndergroundSystem() {
        travelTimes = new HashMap<String, Detail>();
        passangers = new HashMap<Integer, CheckIn>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passangers.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = passangers.remove(id);
        String path = checkIn.stationName + "-" + stationName;

        Detail details;
        details = travelTimes.getOrDefault(path, new Detail());
        details.countTravels++;
        details.travelTime += t - checkIn.time;
        travelTimes.put(path, details);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Detail details = travelTimes.get(startStation + "-" + endStation);

        return details.travelTime / details.countTravels;
    }
}

public class Solution {
    
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
