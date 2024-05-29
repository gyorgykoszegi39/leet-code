public class Solution {
    public int numSteps(String s) {
        int count = 0, n = s.length() - 1, carryBit = 0;
        char bits[] = s.toCharArray();
        while(n >= 1) {
            if(bits[n] - '0' + carryBit == 1) {
                carryBit = 1;
                count++;
            }

            n--;
            count++;
        }

        return count + carryBit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSteps("1"));

        System.out.println(s.numSteps("10"));

        System.out.println(s.numSteps("101"));
    }
}
