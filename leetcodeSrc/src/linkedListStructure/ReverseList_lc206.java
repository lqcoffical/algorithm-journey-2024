package linkedListStructure;

public class ReverseList_lc206 {

    class solution {

        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = head, nxt = head.next;
            while (nxt != null) {
                // 这么写会断链，找不到3节点
                pre.next.next = pre;
                pre.next = null;
                pre = nxt;
                nxt = nxt.next;
            }
            return pre;
        }


        public ListNode reverseList2(ListNode head) {
            // 三指针，相对位置是 pre、head、nxt。且不用特判
            ListNode pre = null, nxt = null;
            while (head != null) {
                // 先保存后面的一个节点，防止断链
                nxt = head.next;
                // 然后反指（第一次是指空）
                head.next = pre;
                // pre/head分别后移
                pre = head;
                head = nxt;
            }
            // 退出循环head==null，要返回pre
            return pre;
        }


        public ListNode reverseList3(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    }

}
