package heapStructure;

import java.util.*;

public class TopKFrequent_lc347 {

    public static int[] topKFrequent(int[] nums, int k) {
        // 用map统计词频
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 构建最小堆，这里要用词频比较，写的时候总用数字比较所以错误几次
        // 最小堆构建还是o1-o2
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        // 遍历map，加入k个值，维护k个大小的最小堆
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.add(key);
            }
        }
        // 统计堆中元素就是topk频率的
        int[] ans = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.print(i + ", ");
        }
    }

}
