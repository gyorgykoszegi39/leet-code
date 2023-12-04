public class Solution {
    public String largestGoodInteger(String num) {
        String[] goodIntegers = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};

        for(String goodInteger : goodIntegers)
            if(num.indexOf(goodInteger) >= 0)
                return goodInteger;
    
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestGoodInteger("6777133339"));
        System.out.println(s.largestGoodInteger("2300019"));
        System.out.println(s.largestGoodInteger("42352338"));
    }
}
