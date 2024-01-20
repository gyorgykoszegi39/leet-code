import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    final static int mod = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;
        int[] prevMin = new int[n];
        int[] nextMin = new int[n];
        Deque<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            prevMin[i] = -1;
            nextMin[i] = n;
        }

        for(int i = 0; i < n; i++) {
            while(!que.isEmpty() && arr[que.peek()] > arr[i])
                nextMin[que.pop()] = i;

            if(!que.isEmpty())
                prevMin[i] = que.peek();
            
            que.push(i);
        }

        for(int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - prevMin[i]) * (nextMin[i] - i)) % mod;
        }

        return (int) result;
    }

    public int sumSubarrayMins1(int[] arr) {        
        return (int)(getMin(arr, 0) % mod);
    }

    private long getMin(int[] arr, int ind) {
        if(ind == arr.length)
            return 0;
        long sum = arr[ind], min = arr[ind];
        for(int i = ind + 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum = (sum + min) % mod;
        }

        return (sum + getMin(arr, ind + 1)) % mod;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumSubarrayMins1(new int[] {3, 1, 2, 4}));
        System.out.println(s.sumSubarrayMins(new int[] {3, 1, 2, 4}));
    }
}
