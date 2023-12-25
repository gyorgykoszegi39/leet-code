public class Solution {
    public int numDecodings(String s) {
        char chs[] = s.toCharArray();

        if(chs[0] == '0')
            return 0;
        int i = s.length() - 2;
        int dp_0, dp_1 = chs[i + 1] == '0' ? 0 : 1, dp_2 = 1; 

        while(i >= 0) {
            if(chs[i] == '0')
                dp_0 = 0;
            else {
                dp_0 = dp_1;

                if(chs[i] == '1' || (chs[i] == '2' && chs[i + 1] - '0' < 7))
                    dp_0 += dp_2;
            }
            dp_2 = dp_1;
            dp_1 = dp_0;
            dp_0 = 0;
            i--;
        }

        return dp_1;   
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("226"));
        System.out.println(s.numDecodings("06"));
        System.out.println(s.numDecodings("1270712"));
    }
}
