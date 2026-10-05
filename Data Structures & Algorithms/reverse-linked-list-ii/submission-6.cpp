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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode dummy { 0, head };
        ListNode* leftPrev { &dummy };
        ListNode* current { head };

        for (int i { 0 }; i < left - 1; i++) {
            leftPrev = current;
            current = current -> next;
        }

        // reverse the correct portion of the array
        int iterations { right - left + 1 };
        ListNode* prev { nullptr };
        for (int i { 0 }; i < iterations; i++) {
            ListNode* tempNext { current -> next };
            current -> next = prev;
            prev = current;
            current = tempNext;
        }

        // reconnect the ends.
        leftPrev -> next -> next = current;
        leftPrev -> next = prev;

        return dummy.next;
    }
};