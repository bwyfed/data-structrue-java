public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
//        ListNode res = removeElements(head.next, val); // 解决后面子链表的删除问题
//        if(head.val == val)
//            return res;
//        else { // head节点不删除
//            head.next = res;
//            return head;
//        }
        // 方法2
//        head.next = removeElements(head.next, val);
//        if (head.val == val)
//            return head.next;
//        else
//            return head;
        // 方法3
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
