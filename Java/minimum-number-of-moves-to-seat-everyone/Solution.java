import java.util.Arrays;

public class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int diff = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i = 0; i < seats.length; i++)
            diff += Math.abs(seats[i] - students[i]);

        return diff;    
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minMovesToSeat(new int[] {3, 1, 5}, new int[] {2, 7, 4}));
        System.out.println(s.minMovesToSeat(new int[] {4, 1, 5, 9}, new int[] {1, 3, 2, 6}));
    }
}
