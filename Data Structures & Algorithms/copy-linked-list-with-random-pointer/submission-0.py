"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToCopy = { None: None }

        # For every node in the list create a copy with just the value in
        # the hashmap.
        current = head
        while current:
            copy = Node(current.val)
            oldToCopy[current] = copy
            current = current.next

        # Reset the current pointer to the head again.
        # For this pass we will be setting the pointers.
        current = head
        while current:
            copy = oldToCopy[current]
            copy.next = oldToCopy[current.next]
            copy.random = oldToCopy[current.random]
            current = current.next
        
        return oldToCopy[head]
        
