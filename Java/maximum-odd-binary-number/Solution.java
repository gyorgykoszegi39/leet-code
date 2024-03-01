public class Solution {

    public String maximumOddBinaryNumber(String s) {
        StringBuilder maxOddNumber = new StringBuilder();
        int count = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '1')
                count++;
        }

        for(int i = 0; i < count - 1; i++)
            maxOddNumber.append('1');

        for(int i = count; i < s.length(); i++)
            maxOddNumber.append('0');
        
        maxOddNumber.append('1');

        return maxOddNumber.toString();
    }
    
    public String maximumOddBinaryNumber1(String s) {
        StringBuilder maxOddNumber = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '1')
                maxOddNumber.insert(0, '1');
            else
                maxOddNumber.append('0');
        }

        maxOddNumber.append('1');
        maxOddNumber.delete(0, 1);

        return maxOddNumber.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.maximumOddBinaryNumber("010"));
        System.out.println(s.maximumOddBinaryNumber("0101"));
    }    
}
