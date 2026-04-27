#include <cstdlib>
#include <vector>


class Node {
public:
    int key { -1 };
    int value { -1 };
    Node* next { nullptr };
};


class MyHashMap {
private:
    static constexpr std::size_t m_arraySize { 1000 };
    std::vector<Node*> m_map;

public:
    MyHashMap() 
    : m_map(m_arraySize) 
    {
        for (std::size_t i { 0 }; i < m_arraySize; ++i)
        {
            m_map[i] = new Node {-1, -1, nullptr};
        }
    }


    std::size_t hash(int key) { return static_cast<std::size_t>(std::abs(key)) % m_arraySize; }
    

    void put(int key, int value) {
        std::size_t index { hash(key) };
        Node* currentNode { m_map[index] };

        while (currentNode -> next != nullptr)
        {
            // Handle update case.
            if (currentNode->next->key == key)
            {
                currentNode->next->value = value;
                return;
            }
            currentNode = currentNode -> next;
        }

        // Handle add case:
        currentNode -> next = new Node { key, value, nullptr };
    }
    
    int get(int key) 
    {
        std::size_t index { hash(key) };
        Node* currentNode { m_map[index] -> next }; // Skip the dummy head node.
        while(currentNode != nullptr)
        {
            // Return the value of the currentNode if the key is the same.
            if ((currentNode -> key) == key)
            {
                return currentNode -> value;
            }

            // If the next node is not a nullptr, continue.
            if (currentNode -> next != nullptr)
            {
                currentNode = currentNode -> next;
                continue;
            }
            break;
        }
        return -1;
    }
    
    void remove(int key) {
        std::size_t index { hash(key) };
        Node* currentNode { m_map[index] }; // Start from the dummy node.

        while(currentNode != nullptr && currentNode -> next != nullptr)
        {
            if (currentNode -> next -> key == key)
            {
                currentNode -> next = currentNode -> next -> next;
                return;
            }
            currentNode = currentNode -> next;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */