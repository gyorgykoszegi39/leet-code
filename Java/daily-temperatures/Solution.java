import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, ind, temperature, maxTemperature = 0;
        int[] warmerTemperatures = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            temperature = temperatures[i];

            if(temperature >= maxTemperature) {
                maxTemperature = temperature;
            } else {
                ind = 1;
                while(temperatures[i + ind] <= temperature)
                    ind += warmerTemperatures[i + ind];

                warmerTemperatures[i] = ind;
            }
        }
     
        return warmerTemperatures;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length, ind;
        int[] warmerTemperatures = new int[n];
        Deque<Integer> colderTemperatures = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!colderTemperatures.isEmpty() && temperatures[i] > temperatures[colderTemperatures.peek()]) {
                ind = colderTemperatures.pop();
                warmerTemperatures[ind] = i - ind;
            }

            colderTemperatures.push(i);
        }
     
        return warmerTemperatures;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        for(int warmerTemperature : s.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.print(warmerTemperature + " ");
        }
    }
}
