public class Solution {
    public int maxScore(String s) {
        char[] chs = s.toCharArray();
        int countOnes = 0, countZeros = chs[0] == '0' ? 1 : 0, maxZeros = countZeros;
        for(int i = 1; i < chs.length - 1; i++) {
            if(chs[i] == '0') {
                countZeros++;
            } else {
                countOnes++;
                countZeros--;
            }
            
            if(countZeros > maxZeros)
                maxZeros = countZeros;
        }
        countOnes += chs[s.length() - 1] == '1' ? 1 : 0;
        
        return maxZeros + countOnes;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxScore("011101"));
        System.out.println(s.maxScore("00111"));
    }
}
