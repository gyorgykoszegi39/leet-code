import java.util.ArrayList;

public class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0)
            return 0;
        
        double[] currChampagneRow, prevChampagneRow = new double[] {poured};
        currChampagneRow = prevChampagneRow;
        for(int i = 0; i < query_row; i++) {
            currChampagneRow = new double[i + 2];
            for(int j = 0; j < prevChampagneRow.length; j++) {
                if(prevChampagneRow[j] > 0)
                currChampagneRow[j] += (prevChampagneRow[j] - 1) / 2;
                currChampagneRow[j + 1] += (prevChampagneRow[j] - 1) / 2;
            }
            prevChampagneRow = currChampagneRow;
        }

        return Math.min(1, currChampagneRow[query_glass]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.champagneTower(1, 1, 1));
        System.out.println(s.champagneTower(2, 1, 1));
        System.out.println(s.champagneTower(100000009, 33, 17));
    }
}


/*
            1
        1       1

    1/4       1/2       1/4
    1/2         1       1/2                 1/4+1/2     1   1/4+1/2             1   1   1

0           0       0           0          0        1/4     1/4     0          0  1/2  1/2 0

1   1   1

0  1/2  1/2 0 ->  1/4 1 1 1/4

0 0 0 0 0




















 */