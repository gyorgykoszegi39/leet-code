import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    final static int mod = 1_000_000_007;

    public int numFactoredBinaryTrees(int[] arr) {
        long result = 0, sum;
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum = 1L;
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0 &&  dp.containsKey(arr[i]/arr[j]))
                    sum = sum + dp.get(arr[j]) * dp.get(arr[i] / arr[j]);
            }

            dp.put(arr[i], sum);
            result = result + sum;
        }

        return (int) (result % mod);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numFactoredBinaryTrees(new int[] {2, 4}));
        System.out.println(s.numFactoredBinaryTrees(new int[] {2, 4, 5, 10}));
    }
}
