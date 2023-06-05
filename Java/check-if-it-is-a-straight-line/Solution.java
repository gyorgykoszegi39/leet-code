public class Solution {
    public static boolean checkStraightLine(int[][] coordinates) {
        
        int x0 = coordinates[0][0], x1 = coordinates[1][0];
        int y0 = coordinates[0][1], y1 = coordinates[1][1];
        int diffX = x1 - x0;
        int diffY = y1 - y0;

        for(int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            
            if(diffY * (x - x0) != diffX * (y - y0))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution.checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
    }
}
/* 
x - x1
/
x2 - x1   = 
y - y1
/
y2 - y1


x - 1 = y - 2
x - y + 1 = 0;

lineD = (y2 - y1)(x - x1) - (x2-x1)(y - y1)
*/