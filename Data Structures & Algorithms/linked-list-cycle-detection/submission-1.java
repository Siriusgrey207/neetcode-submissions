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
    public boolean hasCycle(ListNode head) {
        // Initialise two pointers, slow and fast.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // Move the slow pointer.
            if (slow.next != null) {
                slow = slow.next;
            } else {
                return false;
            }

            // Move the fast pointer.
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else { 
                return false;
            }

            // If we end up with the fast pointing to the slow, then there is a loop.
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }
}
