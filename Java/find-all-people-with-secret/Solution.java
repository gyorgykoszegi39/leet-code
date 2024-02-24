import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashMap<Integer, ArrayList<int[]>> meetingsGraph = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<int[]> meetingsQueue = new ArrayDeque<>();
        int[] peopleWithTheSecret = new int[n];
        Arrays.fill(peopleWithTheSecret, Integer.MAX_VALUE);
        peopleWithTheSecret[0] = 0;
        peopleWithTheSecret[firstPerson] = 0;

        for(int[] meeting : meetings) {
            meetingsGraph.putIfAbsent(meeting[0], new ArrayList<>());
            meetingsGraph.putIfAbsent(meeting[1], new ArrayList<>());
            meetingsGraph.get(meeting[0]).add(meeting);
            meetingsGraph.get(meeting[1]).add(meeting);
        }

        if(meetingsGraph.containsKey(0))
            meetingsQueue.add(new int[] {0, 0});
        if(meetingsGraph.containsKey(firstPerson))
            meetingsQueue.add(new int[] {firstPerson, 0});
        while(!meetingsQueue.isEmpty()) {
            int[] person  = meetingsQueue.poll();
            for(int[] meeting : meetingsGraph.get(person[0])) {
                int nextPerson = person[0] == meeting[0] ? meeting[1] : meeting[0];

                if(person[1] <= meeting[2] && peopleWithTheSecret[nextPerson] > meeting[2]) {
                    meetingsQueue.add(new int[] {nextPerson, meeting[2]});
                    peopleWithTheSecret[nextPerson] = meeting[2];
                }
            }
        }

        for(int i = 0; i < n; i++)
            if(peopleWithTheSecret[i] != Integer.MAX_VALUE)
                result.add(i);

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(Integer person : s.findAllPeople(4, new int[][] {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3))
            System.out.print(person + " ");
    }
}
