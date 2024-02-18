import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Room {
    int roomNumber;
    long usedUntil;
    int numberOfMeetings;

    public Room(int roomNumber, int usedUntil) {
        this.roomNumber = roomNumber;
        this.usedUntil = usedUntil;
        this.numberOfMeetings = 0;
    }
}
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] numberOfMeetings = new int[n];
        long[] availableRooms = new long[n];

        Arrays.sort(meetings, Comparator.comparingInt(row -> row[0]));
        long starts, ends, minWaitingTime;
        int nextAvailableRoom;
        for(int[] meeting : meetings) {
            starts = meeting[0];
            ends = meeting[1];
            minWaitingTime = Long.MAX_VALUE;
            nextAvailableRoom = -1;

            for(int i = 0; i < n; i++) {
                if(availableRooms[i] <= starts) {
                    availableRooms[i] = ends;
                    numberOfMeetings[i]++;
                    nextAvailableRoom = -1;

                    break;
                }

                if(availableRooms[i] < minWaitingTime) {
                    minWaitingTime = availableRooms[i];
                    nextAvailableRoom = i;
                }
            }
            if(nextAvailableRoom != -1) {
                availableRooms[nextAvailableRoom] += (ends - starts);
                numberOfMeetings[nextAvailableRoom]++;
            }
        }
        int maxNumberOfMeetings = numberOfMeetings[0], indOfMaxNumberOfMeetings = 0;
        for(int i = 1; i < n; i++) {
            if(numberOfMeetings[i] > maxNumberOfMeetings) {
                maxNumberOfMeetings = numberOfMeetings[i];
                indOfMaxNumberOfMeetings = i;
            }
        }

        return indOfMaxNumberOfMeetings;
    }

    public int mostBooked1(int n, int[][] meetings) {
        PriorityQueue<Room> meetingsOrder = new PriorityQueue<>(Comparator.<Room, Long>comparing(room -> room.usedUntil).
                                                                thenComparing(room -> room.roomNumber));
        
        ArrayList<Room> rooms = new ArrayList<>();
        boolean[] isOccupied = new boolean[n];

        Arrays.sort(meetings, Comparator.comparingInt(row -> row[0]));
        for(int i = 0; i < n; i++)
            rooms.add(new Room(i, 0));

        long starts, ends;
        int nextAvailableRoom;
        Room currRoom, mostBookedRoom = new Room(0, 0); 
        for(int[] meeting : meetings) {
            starts = meeting[0];
            ends = meeting[1];
            while(!meetingsOrder.isEmpty() && meetingsOrder.peek().usedUntil <= starts) {
                isOccupied[meetingsOrder.poll().roomNumber] = false;
            }
            nextAvailableRoom = availableRoom(isOccupied);
            currRoom = nextAvailableRoom == -1 ? meetingsOrder.poll() : rooms.get(nextAvailableRoom);

            currRoom.numberOfMeetings = currRoom.numberOfMeetings + 1;
            currRoom.usedUntil = Math.max(currRoom.usedUntil + ends - starts, ends);
            isOccupied[currRoom.roomNumber] = true;
            meetingsOrder.add(currRoom);
           
            if(mostBookedRoom.numberOfMeetings == currRoom.numberOfMeetings) {
                if(mostBookedRoom.roomNumber > currRoom.roomNumber)
                    mostBookedRoom = currRoom;                
            }
            if(mostBookedRoom.numberOfMeetings < currRoom.numberOfMeetings) {
                mostBookedRoom = currRoom;                
            }

        }
        
        return mostBookedRoom.roomNumber;
    }

    private int availableRoom(boolean[] rooms) {
        for(int i = 0; i < rooms.length; i++)
            if(!rooms[i])
                return i;
        return -1;
    }

    private void printCurrentMeetings(PriorityQueue<Room> meetings) {
        System.out.println("=========================================================");
        for(Room room : meetings) {
            System.out.println(room.roomNumber + " room, occupied until " + room.usedUntil +", " + room.numberOfMeetings);
        }
        System.out.println("=========================================================");
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mostBooked1(2, new int[][] {{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(s.mostBooked1(3, new int[][] {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
        System.out.println(s.mostBooked1(4, new int[][] {{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}));
        System.out.println(s.mostBooked1(3, new int[][] {{3, 7}, {12, 19}, {16, 17}, {1, 17}, {5, 6}}));
        System.out.println(s.mostBooked1(4, new int[][] {{19, 20}, {14, 15}, {13, 14}, {11, 20}}));
        System.out.println();
        System.out.println(s.mostBooked(2, new int[][] {{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(s.mostBooked(3, new int[][] {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
        System.out.println(s.mostBooked(4, new int[][] {{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}));
        System.out.println(s.mostBooked(3, new int[][] {{3, 7}, {12, 19}, {16, 17}, {1, 17}, {5, 6}}));
        System.out.println(s.mostBooked(4, new int[][] {{19, 20}, {14, 15}, {13, 14}, {11, 20}}));

    }
}
