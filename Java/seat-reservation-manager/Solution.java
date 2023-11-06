import java.util.PriorityQueue;

class SeatManager {
    private int reserve;
    private PriorityQueue<Integer> reservPriorityQueue;
    
    public SeatManager(int n) {
        reserve = 1;
        reservPriorityQueue = new PriorityQueue<Integer>();
    }
    
    public int reserve() {
        if(reservPriorityQueue.isEmpty())
            return reserve++;
        return reservPriorityQueue.poll();
    }
    
    public void unreserve(int seatNumber) {
        if(seatNumber == reserve - 1)
            reserve--;
        else
            reservPriorityQueue.add(seatNumber);
    }
}

public class Solution {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(10);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        seatManager.unreserve(4);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
        System.out.println(seatManager.reserve());
    }
}
