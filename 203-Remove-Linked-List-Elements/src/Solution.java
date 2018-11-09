/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 处理/删除头结点（前面的元素等于val）
        while(head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next;
        }
        if(head == null)
            return null;
        // 删除中间的等于val的节点
        ListNode prev = head;
        while(prev.next != null) { // 遍历到最后一个节点之前的节点
            if(prev.next.val == val) { // 处理到最后一个节点
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}