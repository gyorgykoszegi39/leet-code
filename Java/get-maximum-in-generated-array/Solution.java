
public class Solution {

    public int getMaximumGenerated(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        
        int[] numbers = new int[n + 1];
        int result = 0;
        numbers[0] = 0;
        numbers[1] = 1;

        for(int i = 2; i <= n; i++) {
            numbers[i] = numbers[i / 2];
            numbers[i] += (i % 2 == 0 ? 0 : numbers[(i / 2) + 1]);
            result = Math.max(result, numbers[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getMaximumGenerated(7));
    }
}
