
public class Solution {

    public int romanToInt(String s) {
        int result = 0, prevNumber = 0, number = 0;
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I'-> number = 1;
                case 'V'-> number = 5;
                case 'X'-> number = 10;
                case 'L'-> number = 50;
                case 'C'-> number = 100;
                case 'D'-> number = 500;
                case 'M'-> number = 1000;
            }
            if(prevNumber < number) {
                result -= 2 * prevNumber;
            }
            result += number;
            prevNumber = number;
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
