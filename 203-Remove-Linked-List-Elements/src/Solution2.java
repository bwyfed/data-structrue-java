public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        // 使用虚拟头节点作为链表第一个节点，在head节点之前(重置dummyHead.next=head指针)
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }
}
