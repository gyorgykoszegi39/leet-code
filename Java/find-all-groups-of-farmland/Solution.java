import java.util.ArrayList;

public class Solution {


    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = land.length, m = land[0].length, i2, j2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1) {
                    j2 = j;
                    while(j2 < m && land[i][j2] == 1) {
                        j2++;
                    }
                    j2--;
                    i2 = i;
                    while(i2 < n && land[i2][j] == 1) {
                        i2++;
                    }
                    i2--;
                    result.add(new int[] {i, j, i2, j2});

                    markLand(land, i, j, i2, j2);
                }
            }
        }

        int[][] coordinates = new int[result.size()][4];
        int k = 0;
        for(int[] c : result) {
            coordinates[k++] = c;
        }
        
        return coordinates;
    }

    private void markLand(int[][] land, int x, int y, int n, int m) {
        for(int i = x; i <= n; i++)
            for(int j = y; j <= m; j++)
                land[i][j] = 2;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        for(int[] coordinates :  s.findFarmland (new int[][] {
            {1, 0, 0}, 
            {0, 1, 1},
            {0, 1, 1}})) {

            System.out.println(coordinates[0] +  " " + coordinates[1] +  " " + coordinates[2] +  " "+ coordinates[3]);
        }

    }
}
