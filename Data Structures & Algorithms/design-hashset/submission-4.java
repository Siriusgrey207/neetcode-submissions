class MyHashSet {
    private List<Integer>[] buckets;
    private int size;

    public MyHashSet() {
        size = 1000; // number of buckets
        buckets = new ArrayList[size];
        
        // Initialize each bucket
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */