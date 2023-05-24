import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pascalsTriangleRow = new ArrayList<Integer>();
        pascalsTriangleRow.add(1);

        while( rowIndex > 0) {
            for(int i = 0; i < pascalsTriangleRow.size() - 1; i++) {
                pascalsTriangleRow.set(i, pascalsTriangleRow.get(i) + pascalsTriangleRow.get(i + 1));
            }

            pascalsTriangleRow.add(0, 1);
            rowIndex--;
        }

        return pascalsTriangleRow;
    }

    public static void main(String[] args) {
        System.out.println(Solution.getRow(0));
        System.out.println(Solution.getRow(1));
        System.out.println(Solution.getRow(2));
        System.out.println(Solution.getRow(3));
    }
}

/*          
0    [1],                        1
1    [1, 1],                     2
2    [1, 2, 1],                  4
3    [1, 3, 3, 1],               8
4    [1, 4, 6, 4, 1]             16
5    [1, 5, 10, 10, 5, 1]        32
6    [1, 6, 15, 20, 15, 6, 1]    64
*/
