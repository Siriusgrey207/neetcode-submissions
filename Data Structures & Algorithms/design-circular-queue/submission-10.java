// Define a doubly-linked list class.
class ListNode {
    public int value = 0;
    public ListNode prev = null;
    public ListNode next = null;

    public ListNode(int value, ListNode prev, ListNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class MyCircularQueue {
    int space = -1;
    ListNode left;
    ListNode right;

    public MyCircularQueue(int k) {
        this.space = k;
        this.left = new ListNode(0, null, null);
        this.right = new ListNode(0, null, null);
        this.left.next = right;
        this.right.prev = left;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        ListNode newNode = new ListNode(value, right.prev, right);
        right.prev.next = newNode;
        right.prev = newNode;
        space -= 1;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        ListNode toDequeue = left.next;
        ListNode nextToDequeue = toDequeue.next;
        nextToDequeue.prev = left;
        left.next = nextToDequeue;
        space += 1;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) return -1;
        return this.left.next.value;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return this.right.prev.value;
    }
    
    public boolean isEmpty() {
        return this.left.next == this.right;
    }
    
    public boolean isFull() {
        return this.space == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */