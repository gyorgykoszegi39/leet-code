public class Solution {

    public static int[] countBits(int n) {
        int[] bits = new int[n+1];
        bits[0] = 0;
        for(int i = 1; i <= n; i++) {
            bits[i] = bits[i/2] + i % 2;
        }
        
        return bits;
    }
    public static void main(String[] args) {
        for (int countBit : Solution.countBits(5)) {
            System.out.println(countBit);
        }
    }
    
}
