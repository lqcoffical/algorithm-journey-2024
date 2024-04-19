package linkedListStructure;

public class RemoveElements_lc203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            if (cur.val == val) {
                ListNode nxt = cur.next;
                pre.next = cur.next;
                cur = nxt;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        // 减少变量的版本，cur作为被删除节点前面的节点
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        // 不用假节点，分类讨论的方法，这个最快0ms
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
