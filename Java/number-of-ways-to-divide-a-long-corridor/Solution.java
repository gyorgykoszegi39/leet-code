public class Solution {
    final static int mod = 1_000_000_007;

    public int numberOfWays(String corridor) {
        long count = 1, hasTwoSeats = 0, plants = 1;
        char []corridors = corridor.toCharArray();
        int i = 0;
        while(i < corridors.length && hasTwoSeats != 2) {
            if(corridors[i] == 'S')
                hasTwoSeats++;
            i++;
        }
        
        if(hasTwoSeats < 2)
            return 0;
        
        while(i < corridors.length) {
            System.out.println("i - s : " + i + " " + corridors[i]);
            System.out.println("p: " + plants);
            count = (count * plants) % mod;
            plants = 1;
            while(i < corridors.length && hasTwoSeats == 2 && corridors[i] == 'P') {
                plants++;
                i++;

                            System.out.println("p1: " + plants);

            }

            hasTwoSeats = 0;
            while(i < corridors.length && hasTwoSeats != 2) {
                if(corridors[i] == 'S')
                    hasTwoSeats++;
                i++;
            }
        }
        
        if(hasTwoSeats == 1)
            return 0;
        
        if(hasTwoSeats == 2)
            count = (count * plants) % mod;

        return (int) count % mod;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfWays("SPSPPSSPSSSS"));
        //System.out.println(s.numberOfWays("SSPPSPS"));
        //System.out.println(s.numberOfWays("PPSPSP"));
        //System.out.println(s.numberOfWays("S"));
    }

}
