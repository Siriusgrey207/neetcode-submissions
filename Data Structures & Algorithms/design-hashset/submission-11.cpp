#include <vector>

class MyHashSet {
private:
    constexpr static std::size_t bucketsLength { 1000 };
    std::vector<std::vector<int>> buckets;

    int hash(int key) { return key % bucketsLength; }

public:
    MyHashSet() 
    : buckets(bucketsLength)
    {}
    
    
    void add(int key) {
        int bucketIndex { hash(key) };
        std::vector<int>& bucket { buckets[bucketIndex] };

        for (int currentEl: bucket) {
            if (currentEl == key) return;
        }

        bucket.push_back(key);
    }

    
    void remove(int key) {
        int bucketIndex { hash(key) };
        std::vector<int>& bucket { buckets[bucketIndex] };

        for (auto it { bucket.begin() }; it != bucket.end(); ++it)
        {
            if (*it == key) bucket.erase(it);
            return;
        }

        // Alternative:
        // bucket.erase(std::remove(bucket.begin(), bucket.end(), key), bucket.end());
    }
    
    bool contains(int key) {
        int bucketIndex { hash(key) };
        std::vector<int>& bucket { buckets[bucketIndex] };
        
        for (int el: bucket) {
            if (el == key) return true;
        }

        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */