
public class Solution {
    public String decodeAtIndex(String s, int k) {
        int i = 0, n = s.length(); 
        long m = 0;
        while(i < n && k > m) {
            if(s.charAt(i) >= '2' && s.charAt(i) <= '9') {
                m *= s.charAt(i) - '0';
            } else {
                m++;
            }
            i++;
        }

        i--;
        while(i >= 0) {
            if(s.charAt(i) >= '2' && s.charAt(i) <= '9') {
                m /= s.charAt(i) - '0';
                k %= m;
            } else {
                if(k % m == 0)
                    return s.charAt(i) + "";
                m--;
            }
            i--;
        }
        return "-1";
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeAtIndex("leet2code3", 10));
        System.out.println(s.decodeAtIndex("ha22", 5));
        System.out.println(s.decodeAtIndex("a22", 1));
        System.out.println(s.decodeAtIndex("a2b3c4d5e6f7g8h9", 9));
        System.out.println(s.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
}
