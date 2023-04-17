import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i = 1; i < candies.length; i++) {
            if(max < candies[i]) {
                max = candies[i];
            }
        }

        List<Boolean> arrList = new ArrayList<Boolean>();
        for(int candy : candies) {
            arrList.add((candy + extraCandies) >= max);
        }

        return arrList;
    }
    public static void main(String args[]) {

        int candies[] = {2, 3, 5, 1, 3};
        System.out.println(Solution.kidsWithCandies(candies, 3));
    }
}
