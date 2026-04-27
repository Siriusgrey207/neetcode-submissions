# The value in the key-value pair of our map will be a linked
# list of ListNode elements. Below we start off by defining our
# ListNode class.

class ListNode:
    def __init__(self, key = -1, value = -1, next = None):
        self.key = key;
        self.value = value;
        self.next = next;

# This is the main map class:
class MyHashMap:

    # In the constructor, we initialise the map array with 1000 elements
    # each of which is a list node - the start of the linked list.
    def __init__(self):
        self.map = [ListNode() for i in range(1000)]



    # Returns the correct linked list location the value should be stored.
    def hash(self, key) -> int:
        return key % len(self.map)



    # Effectively a put or update operation.
    def put(self, key: int, value: int) -> None:

        # Find the start of the correct linked list.
        currentNode = self.map[self.hash(key)]
        
        # Traverse and update the node if it already exists.
        while currentNode.next:
            if currentNode.next.key == key:
                currentNode.next.value = value
                return
            currentNode = currentNode.next;

        # If the node does node does not exist, add it at the end.
        currentNode.next = ListNode(key, value, None)
        


    # Finds and returns the value for a given key. If no such value is found,
    # it returns -1.
    def get(self, key: int) -> int:
        # Get the head of the correct linked list.
        currentNode = self.map[self.hash(key)].next

        while currentNode:
            if currentNode.key == key:
                return currentNode.value
            currentNode = currentNode.next
        
        return -1


    def remove(self, key: int) -> None:
        currentNode = self.map[self.hash(key)]

        while currentNode and currentNode.next:
            if currentNode.next.key == key:
                currentNode.next = currentNode.next.next
                return
            currentNode = currentNode.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)