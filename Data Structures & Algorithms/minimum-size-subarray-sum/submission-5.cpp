class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left { 0 };
        int total { 0 };
        int res { INT_MAX };

        for (std::size_t right { 0 }; right < nums.size(); right++) {
            total += nums[right];

            while (total >= target) {
                res = (right - left + 1) < res ? right - left + 1 : res;
                total -= nums[left];
                left++;
            }
        }

        return res == INT_MAX ? 0 : res;
    }
};