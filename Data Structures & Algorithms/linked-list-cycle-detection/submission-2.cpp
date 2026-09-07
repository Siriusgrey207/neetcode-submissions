/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    bool hasCycle(ListNode* head) {
        std::unordered_set<ListNode*> seenNodes {};
        ListNode* current { head };

        while (current != nullptr) {
            if (seenNodes.find(current) != seenNodes.end()) {
                return true;
            }

            seenNodes.insert(current);
            current = current -> next;
        }

        return false;
    }
};
