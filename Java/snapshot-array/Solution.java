import java.util.ArrayList;
import java.util.List;

class SnapshotArray {
    private int snap_id = 0;
    List<ArrayList<int[]>> snapshotArray;
    public SnapshotArray(int length) {
        snapshotArray = new ArrayList<ArrayList<int[]>>(length);

        while(length > 0) {
            length--;
            ArrayList<int[]> al = new ArrayList<int[]>();
            al.add(new int[]{snap_id, 0});
            snapshotArray.add(al);
        }
    }
    
    public void set(int index, int val) {
        snapshotArray.get(index).add(new int[] {snap_id, val});
    }
    
    public int snap() {
        snap_id++;
        return snap_id - 1;
    }
    
    public int get(int index, int snap_id) {
        return findValue(snapshotArray.get(index), snap_id);
    }

        private int findValue(ArrayList<int[]> al, int snap_id) {
        int left = 0, right = al.size() - 1, mid;

        while(left < right) {
            mid = (left + right + 1) / 2;
            if(al.get(mid)[0] <= snap_id) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return al.get(left)[1];
    }
}

public class Solution {

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3);
        snapshotArr.set(0, 5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        System.out.println(snapshotArr.get(0,0));


        SnapshotArray snapshotArr2 = new SnapshotArray(1);
        snapshotArr2.set(0, 15);
        snapshotArr2.snap();
        snapshotArr2.snap();  
        snapshotArr2.snap();
        System.out.println(snapshotArr2.get(0,2));
        snapshotArr2.snap();  
        snapshotArr2.snap();
        System.out.println(snapshotArr2.get(0,0));
    }
}
