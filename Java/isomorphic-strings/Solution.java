public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapStoT = new int[128];
        int[] mapTtoS = new int[128];
        char tChar;

        int i = 0;
        for(char sChar : s.toCharArray()) {
            tChar = t.charAt(i);
            if(mapTtoS[sChar] == 0)
                mapTtoS[sChar] = tChar;
            if(mapStoT[tChar] == 0)
                mapStoT[tChar] = sChar;

            if(mapTtoS[sChar] != tChar || mapStoT[tChar] != sChar)
                return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
    }
}