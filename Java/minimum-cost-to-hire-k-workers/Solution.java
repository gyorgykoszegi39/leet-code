import java.util.Arrays;
import java.util.PriorityQueue;


class Worker implements Comparable<Worker> {
    int quality, wage;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }

    @Override
    public int compareTo(Worker worker) {
        return Integer.compare(wage * worker.quality, quality * worker.wage);
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        int sum = 0;
        double result = 1e15;
        PriorityQueue<Integer> group = new PriorityQueue<>();
        for (Worker worker : workers) {
            group.add(-worker.quality);
            sum += worker.quality;
            if (group.size() > k)
                sum += group.poll();
            if (group.size() == k)
                result = Math.min(result, (double) sum * worker.wage / worker.quality);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2));
        System.out.println(s.mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3));
    }
}
