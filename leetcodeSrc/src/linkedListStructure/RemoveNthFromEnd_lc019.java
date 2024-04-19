package linkedListStructure;

public class RemoveNthFromEnd_lc019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 用哑节点，要不然得讨论删除的是不是头节点，没讨论明白
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // 这里要防止节点不够，fast直接出去
        for (int i = n; i > 0 && fast.next != null; i--) {
            fast = fast.next;
        }
        // 这样走slow是停在要删除的节点的前一个
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
