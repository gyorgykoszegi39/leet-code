
public class Solution {
    public int largestAltitude(int[] gain) {
        int sum = gain[0], max = Math.max(0, sum);

        for(int i = 1; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestAltitude(new int[] {-5,1,5,0,-7}));
    }
}
