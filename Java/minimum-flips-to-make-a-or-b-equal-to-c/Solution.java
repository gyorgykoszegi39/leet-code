
public class Solution {
    public static int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            Boolean aBitIsTrue = (a & mask) != 0;
            Boolean bBitIsTrue = (b & mask) != 0;
            Boolean cBitIsTrue = (c & mask) != 0;

            if(!cBitIsTrue.equals(aBitIsTrue || bBitIsTrue)) {
                count++;

                if(aBitIsTrue && bBitIsTrue)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minFlips(12, 56, 95));
    }
}
