public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int mLast, pLast, gLast;

        mLast = findLastIndexOfAGarbage(garbage, "M");
        pLast = findLastIndexOfAGarbage(garbage, "P");
        gLast = findLastIndexOfAGarbage(garbage, "G");

        count += countTravelTimeToLastGarbage(travel, mLast);
        count += countTravelTimeToLastGarbage(travel, pLast);
        count += countTravelTimeToLastGarbage(travel, gLast);

        for(String g : garbage) {
            count += g.length();
        }
        return count;
    }

    private int findLastIndexOfAGarbage(String[] garbage, String type) {
        for(int i = garbage.length - 1; i > 0; i--)
            if(garbage[i].contains(type))
                return i;
        return -1;
    }

    private int countTravelTimeToLastGarbage(int[] travel, int n) {
        int count = 0;
        for(int i = 0; i < n; i++)
            count += travel[i];

        return count;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[] {2, 4, 3}));
    }
}
