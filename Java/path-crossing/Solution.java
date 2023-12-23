import java.util.HashSet;

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
        HashSet<Coordinate> coords = new HashSet<>();
        Coordinate key;
        coords.add(new Coordinate(x, y));

        for(char ch : path.toCharArray()) {
            switch(ch) { 
                case 'N' -> y++; 
                case 'S' -> y--; 
                case 'E' -> x++; 
                case 'W' -> x--; 
            }
            key = new Coordinate(x, y);
            if(coords.contains(key))
                return true;
            
            coords.add(key);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPathCrossing("NES"));
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
