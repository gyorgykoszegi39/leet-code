import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        pascalsTriangle.add(firstRow);
        int i = 1;
        while(i < numRows) {
            List<Integer> prevRowList = pascalsTriangle.get(i - 1);
            List<Integer> newRowList = new ArrayList<Integer>();

            newRowList.add(1);
            for(int j = 1; j < prevRowList.size(); j++) {
                newRowList.add(prevRowList.get(j - 1) + prevRowList.get(j));
            }
            newRowList.add(1);

            pascalsTriangle.add(newRowList);
            i++;
        }

        return pascalsTriangle;
    }
    
    public static void main(String[] args) {
        System.out.println(Solution.generate(5));
    }
}
