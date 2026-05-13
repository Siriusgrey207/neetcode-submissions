#include <unordered_map>
#include <vector>

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int result { 0 };
        int currentSum { 0 };
        std::unordered_map<int, int> prefixSums { std::pair<int, int> { 0, 1 } };

        for (int num : nums) {
            currentSum += num;
            int difference = currentSum - k;
            if (prefixSums.contains(difference)) {
                result += prefixSums[difference];
            }
            prefixSums[currentSum]++;
        }

        return result;
    }
};