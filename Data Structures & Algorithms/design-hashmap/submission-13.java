class Node {
    public int key = -1;
    public int value = -1;
    public Node next = null;

    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


class MyHashMap {
    private final int mapLength = 1000;
    private Node[] map = new Node[mapLength];


    public MyHashMap() {
        for (int i = 0; i < mapLength; i++) {
            map[i] = new Node(-1, -1, null);
        }
    }


    // Hashing function, used to determine in which linked list a key-value pair
    // should be stored.
    private int hash(int key) { return Math.abs(key) % mapLength; }
    

    // Acts as an add or update operation.
    public void put(int key, int value) {
        int index = hash(key);
        Node currentNode = this.map[index];

        // For every node in the list of nodes...
        while(currentNode.next != null) {
            // Handle update case:
            if (currentNode.next.key == key) {
                currentNode.next.value = value;
                return;
            }
            currentNode = currentNode.next;
        }

        // If the key is not in the linked list we create a new element the key-value pair and attach it to the end.
        currentNode.next = new Node(key, value, null);
    }
    
    
    public int get(int key) {
        int index = hash(key);
        Node currentNode = this.map[index].next;

        // Traverse the linked list, and try to find a node with the correct key:
        while (currentNode != null) {
            if (currentNode.key == key) return currentNode.value;
            currentNode = currentNode.next;
        }

        // Otherwise simply return -1:
        return -1;
    }
    
    // Traverses the linked list, and if a node with the given key is found, that node is removed from the list.
    public void remove(int key) {
        int index = hash(key);
        Node currentNode = this.map[index];

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.key == key) {
                currentNode.next = currentNode.next.next;
                return;
            }

            currentNode = currentNode.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */