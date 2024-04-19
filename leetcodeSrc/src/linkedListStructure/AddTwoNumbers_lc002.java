package linkedListStructure;

public class AddTwoNumbers_lc002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建节点连在后面
        ListNode ans = null, cur = null;
        int carry = 0;
        // for循环里面注意中间的条件式满足才执行，别写反了
        for (int sum, val;
             l1 != null || l2 != null;
             l1 = l1 == null ? null : l1.next,
                     l2 = l2 == null ? null : l2.next) {

            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                // 这里注意cur要后移
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }

}
