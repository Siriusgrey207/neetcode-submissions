class MyHashSet {
    private List<Integer>[] buckets;
    private int size = 1000;

    // Initialise the buckets list and each of the buckets.
    public MyHashSet() {
        buckets = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    // Hash function responsible for the determination of where an element should be put.
    public int hash(int key) { return key % size; }

    // Adds an element in a bucket.
    public void add(int key) {
        int bucketIndex = hash(key);
        if (!buckets[bucketIndex].contains(key))
            buckets[bucketIndex].add(key);
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