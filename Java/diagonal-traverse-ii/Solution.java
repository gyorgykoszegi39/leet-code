import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int row = 0, rows = nums.size();
        List<Integer> line = new ArrayList<>();
        int []node;
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(new int[] {0, 0});
        while(!nodes.isEmpty()) {
            node = nodes.poll();
            line.add(nums.get(node[0]).get(node[1]));

            if(row + 1 < rows && node[1] == 0) {
                row++;
                nodes.add(new int[] {row, 0});
            }

            if(node[1] + 1< nums.get(node[0]).size())
                nodes.add(new int[]{node[0], node[1] + 1});
        }

        int[] result = new int[line.size()];
        for(int i = 0; i < line.size(); i++){
            result[i] = line.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(6);
        l2.add(7);

        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(8);

        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(9);
        l4.add(10);
        l4.add(11);

        List<Integer> l5 = new ArrayList<Integer>();
        l5.add(12);
        l5.add(13);
        l5.add(14);
        l5.add(15);
        l5.add(16);

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        matrix.add(l1);
        matrix.add(l2);
        matrix.add(l3);
        matrix.add(l4);
        matrix.add(l5);

        for(int num : s.findDiagonalOrder(matrix)) {
            System.out.print(num + " ");
        }

    }
}
