/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {void}
     */
    reorderList(head: ListNode | null): void {
        if (head === null || head.next === null) return;

        // 1. Find the start and end of the linked list.
        let slow: ListNode = head;
        let fast: ListNode = head.next;
        while (fast !== null && fast.next !== null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now slow points to the middle element of the linked list and fast points to the last element.

        // 2. Reverse the second half of the list.
        let second: ListNode = slow.next; // The first element of the second half.
        slow.next = null;
        let prev: ListNode = null;

        while (second !== null) {
            let rightTemp: ListNode = second.next;
            second.next = prev;
            prev = second;
            second = rightTemp;
        }
        // "second" now points to the last elements of the linked list.
        //

        // 3. Merge the two parts of the list.
        let first: ListNode = head;
        second = prev;
        while (second !== null) {
            let temp1 = first.next;
            let temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}




















