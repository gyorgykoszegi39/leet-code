
public class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCountBeams = 0, countBeams, countLaserBeams = 0;
        for(String row : bank) {
            countBeams = 0;
            for(char ch : row.toCharArray())
                countBeams += ch - '0';
            
            if(countBeams == 0)
                continue;
            
            countLaserBeams += prevCountBeams * countBeams;
            prevCountBeams = countBeams;
        }

        return countLaserBeams;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfBeams(new String[] {"011001", "000000", "010100", "001000"}));
    }
}
