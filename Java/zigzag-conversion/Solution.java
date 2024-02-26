public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;
        
        int n = s.length();
        char[] chars = s.toCharArray();
        char[] result = new char[n];
        int k, curr = 0, cycle = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < n; j = j + cycle){
                result[curr++] = chars[j];
                k = (j - i) + cycle - i;
                if(i != 0 && i != numRows - 1 && k < n)
                    result[curr++] = chars[k];
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Solution chars = new Solution();

        System.out.println(chars.convert("PAYPALISHIRING", 3));
        System.out.println(chars.convert("PAYPALISHIRING", 4));
    }
}