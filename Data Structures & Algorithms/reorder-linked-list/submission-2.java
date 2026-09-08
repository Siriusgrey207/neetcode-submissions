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
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;

        // 1. Find the mid and ends of the Linked list.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        // "second" is the first element of the second part of the list
        ListNode second = slow.next;
        slow.next = null; // The last element after the merger points to null;
        ListNode prev = null;

        while (second != null) {
            ListNode rightTemp = second.next;
            second.next = prev;
            prev = second;
            second = rightTemp;
        }

        // 3. Merge the two halves
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
