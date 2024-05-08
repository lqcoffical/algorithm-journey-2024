package heapStructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMeetingRooms_lc252 {

    public static int minMeetingRooms(int[][] meeting) {
        int n = meeting.length;
        // 先根据开始时间从小到大排序
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
        Queue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        // 堆里维护的是结束时间
        for (int i = 0; i < n; i++) {
            // 看结束时间有没有小于等于开始时间的，有的话肯定没有相交，所以从堆里弹出。
            // 因为是小根堆，剩下的都是大于的，有相交。那么此时堆的size就是一个可能的答案
            while (!heap.isEmpty() && heap.peek() <= meeting[i][0]) {
                heap.poll();
            }
            // 把当前来到的结束时间加入堆，自己肯定和自己相交
            heap.add(meeting[i][1]);
            // 更新答案始终为最大
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
