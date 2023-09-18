
public class Solution {

    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(n >= 0 || m >= 0 || carry == 1) {
            if(n >= 0) {
                carry += a.charAt(n) - 48;
                n--;
            }

            if(m >= 0) {
                carry += b.charAt(m) - 48;
                m--;
            }
            result.append(carry % 2);

            carry /= 2;
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1010", "1011"));
        System.out.println(s.addBinary("11", "1"));
    }
}
