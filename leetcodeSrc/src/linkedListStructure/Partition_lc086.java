package linkedListStructure;

public class Partition_lc086 {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 分析：用四个指针把小于x和大于x的范围扩出来，一开始都是从头开始
            ListNode leftHead = null, leftTail = null;
            ListNode rightHead = null, rightTail = null;
            ListNode nxt = null;
            while (head != null) {
                // 先保存下一个，防止断链
                nxt = head.next;
                // 要注意尾后面指针要悬空，因为head就是目前讨论的节点，所以head.next = null;因为尾后面不知道挂哪个节点
                head.next = null;
                if (head.val < x) {
                    if (leftHead == null) {
                        leftHead = head;
                    } else {
                        leftTail.next = head;
                    }
                    // 上面的else和这句就是leftTail挂上当前的，然后tail后移，注意一下这种代码风格
                    leftTail = head;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                // head始终后移，表示当前正在检查的链表节点
                head = nxt;
            }
            if (leftHead == null) {
                return rightHead;
            }
            leftTail.next = rightHead;
            return leftHead;
        }
    }

}
