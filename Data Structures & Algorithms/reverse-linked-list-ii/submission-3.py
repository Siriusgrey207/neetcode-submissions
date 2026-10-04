# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)

        # Make leftPrev point to the element before the left node;
        # make current point to the "left" element.
        leftPrev, current = dummy, head
        for i in range(left - 1):
            leftPrev, current = current, current.next

        # Now reverse the portion
        prev = None
        for i in range(right - left + 1):
            tempNext = current.next
            current.next = prev
            prev = current
            current = tempNext
        
        # Reconnext the rotated segment.
        leftPrev.next.next = current;
        leftPrev.next = prev;

        return dummy.next;



        