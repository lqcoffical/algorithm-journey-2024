package heapStructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class HalveArray_lc2208 {
    // 实际就是贪心，每次要那当前最大数减少一半，次数就是最小的
    public int halveArray(int[] nums) {
        // 大根堆
        Queue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            heap.add((double) num);
            sum += num;
        }
        sum /= 2;
        int ans = 0;
        for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }
}
