import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> asteroidsQue = new LinkedList<Integer>();

        asteroidsQue.add(asteroids[0]);
        for(int i = 1; i < n; i++) {

            if(asteroids[i] < 0) {
                //remove + es -
                while(!asteroidsQue.isEmpty() && asteroidsQue.peekLast() > 0 && asteroidsQue.peekLast() < -asteroids[i]) {
                    asteroidsQue.pollLast();
                }

                if(asteroidsQue.isEmpty() || asteroidsQue.peekLast() < 0) {
                    asteroidsQue.add(asteroids[i]);
                } else if(asteroidsQue.peekLast() == -asteroids[i]){
                    asteroidsQue.pollLast();
                }

            } else {
                asteroidsQue.add(asteroids[i]);
            }
        }
        return asteroidsQue.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        for(int i : s.asteroidCollision(new int[] {5, 10, -5}))
            System.out.print(i + " ");
        System.out.println();
        for(int i : s.asteroidCollision(new int[] {5, -5}))
            System.out.print(i+ " ");
        System.out.println();
        for(int i : s.asteroidCollision(new int[] {10, 2, -5}))
            System.out.print(i + " ");
        System.out.println();
        for(int i : s.asteroidCollision(new int[] {-2, -5, 5, 6}))
            System.out.print(i + " ");
        System.out.println();
        for(int i : s.asteroidCollision(new int[] {-2, -2, 1, -2}))
            System.out.print(i + " ");
        System.out.println();
        for(int i : s.asteroidCollision(new int[] {1, -1, -2, -2}))
            System.out.print(i + " ");
        System.out.println();
    }
}
