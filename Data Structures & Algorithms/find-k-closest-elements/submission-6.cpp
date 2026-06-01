class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        std::size_t left { 0 };
        std::size_t right { arr.size() - 1 };

        while (right - left >= k) {
            int leftDiff { std::abs(x - arr[left]) };
            int rightDiff { std::abs(x - arr[right]) };

            if (leftDiff <= rightDiff) {
                right--;
            } else {
                left++;
            }
        } 

        return std::vector<int>(arr.begin() + left, arr.begin() + right + 1);
    }
};