/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private final static ListNode dummy = new ListNode();
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 归并
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = sortList(head1);
        head2 = sortList(head2);

        ListNode current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
                current = current.next;
            } else {
                current.next = head2;
                head2 = head2.next;
                current = current.next;
            }
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        return dummy.next;
    }
}
// @lc code=end

