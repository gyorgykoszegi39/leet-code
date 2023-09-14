
public class Solution {

    public int isBefore(String s, int n, int i) {
        if(i + 1 >= n)
            return 0;
        else {
            char c = s.charAt(i), nextC = s.charAt(i + 1);
            switch(c) {
                case 'I':
                    if(nextC == 'V' || nextC == 'X')
                        return 2;
                    break;
                case 'X':
                    if(nextC == 'L' || nextC == 'C')
                        return 20;
                    break;
                case 'C':
                    if(nextC == 'D' || nextC == 'M')
                        return 200;
                    break;
            }
        }

        return 0;

    }
    public int romanToInt(String s) {
        int result = 0, n = s.length();
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    result += 1;
                    result -= isBefore(s, n, i);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    result -= isBefore(s, n, i);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    result -= isBefore(s, n, i);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));
    }
    
}
