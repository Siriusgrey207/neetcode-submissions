class MyHashSet {
    // A list of lists. Each list is an ArrayList bucket
    private List<Integer>[] buckets;
    private int size; // Number of buckets.


    // Constructor - Initialise the size, the buckets list and each bucket
    // in that list.
    public MyHashSet() {
        size = 1000;
        buckets = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    // Hash function, responsible for determining in which bucket a
    // given value should be put.
    private int hash(int key) {
        return key % size;
    }

    // Adds an element in a bucket.
    public void add(int key) {
        int bucketIndex = hash(key);
        List<Integer> bucket = buckets[bucketIndex];

        if (!bucket.contains(key))
            bucket.add(key);
    }

    // Remove an element from the correct bucket.
    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove(Integer.valueOf(key));
    }
    
    // Checks if the correct bucket contains a given element.
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */