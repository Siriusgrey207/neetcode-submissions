# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head
        fast = head.next

        # After this loop, slow now points to the middle element and fast
        # points to the last element.
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # second half of the list
        second = slow.next

        # Reverse the second half of the list
        slow.next = None
        prev = None
        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp
        
        # Second part has been reverse
        # Now merge the two pars of the list
        first = head # left half
        second = prev # right half

        while second:
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2
