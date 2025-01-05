package linkedListStructure;

public class HasCycle_lc141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && slow != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
