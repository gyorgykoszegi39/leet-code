import java.util.HashMap;

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object coordinate) {
        Coordinate c = (Coordinate)coordinate;
        return x == c.x && y == c.y;
    }

    @Override
    public int hashCode() {
        return x * 10000 + y;
    }
}
public class Solution {
    
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashMap<Coordinate, Boolean> coords = new HashMap<>();
        coords.put(new Coordinate(x, y), true);

        for(char ch : path.toCharArray()) {
            if(ch == 'N') {
                y++;
            } else if(ch == 'S') {
                y--;
            } else if(ch == 'E') {
                x++;
            } else if(ch == 'W') {
                x--;
            }
            Coordinate key = new Coordinate(x, y);
            if(coords.containsKey(key))
                return true;
            else
                coords.put(key, true);

        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPathCrossing("NES"));
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
