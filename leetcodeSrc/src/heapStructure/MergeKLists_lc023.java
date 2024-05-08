package heapStructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists_lc023 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 建立小根堆
        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 遍历所有的头
        for (ListNode h : lists) {
            if (h != null) {
                heap.add(h);
            }
        }
        // 特判
        if (heap.isEmpty()) {
            return null;
        }
        // 先弹出一个节点做总头部
        ListNode h = heap.poll();
        ListNode pre = h;
        // pre是合并后主链表的串联指针，cur是哪个链表要入堆的指针
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            // 这里写pre=pre.next也是可以的，就是往下串，但是有cur变量了，就直接写变量
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }

}
