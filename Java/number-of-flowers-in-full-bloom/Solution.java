import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length], end = new int[flowers.length];

        for(int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0; i < people.length; i++) {
            people[i] = binarySearch(start, people[i] + 1) - binarySearch(end, people[i]);
        }

        return people;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid;

        while(left < right) {
            mid = left + (right - left) / 2;
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left] >= target ? left : left + 1;
    }

    public int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        int count = 0;
        Queue<int[]> sweepLine = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < people.length; i++)
            sweepLine.offer(new int[] {people[i], 1, i});

        for(int i = 0; i < flowers.length; i++) {
            sweepLine.offer(new int[] {flowers[i][0], 0});
            sweepLine.offer(new int[] {flowers[i][1], 2});
        }

        while(!sweepLine.isEmpty()) {
            int[] event = sweepLine.poll();

            if(event[1] == 0) {
                count++;
            } else if (event[1] == 2){
                count--;
            } else {
                people[event[2]] = count;
            }
        }
        
        return people;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int r : s.fullBloomFlowers(new int[][] {{1, 6}, {3, 7},{9, 12}, {4, 13}}, new int[] {2, 3, 7, 11})) {
            System.out.println(r);
        }

        for(int r : s.fullBloomFlowers1(new int[][] {{1, 6}, {3, 7},{9, 12}, {4, 13}}, new int[] {2, 3, 7, 11})) {
            System.out.println(r);
        }
    }
}
