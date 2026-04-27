class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.size() == 0) return 0;

        std::size_t leftPtr { 0 };
        std::size_t rightPtr { nums.size() };

        while(leftPtr < rightPtr) {
            if (nums[leftPtr] == val) {
                nums[leftPtr] = nums[rightPtr - 1];
                rightPtr--;
            } else {
                leftPtr++;
            }
        }

        return rightPtr;
    }
};