class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # The final result we are returning.
        result = 0
        # The current sum that we will be adding to the prefixSums
        currentSum = 0
        # A *prefix sum* : *count* map
        prefixSums = { 0 : 1 }

        for n in nums:
            currentSum += n
            diff = currentSum - k # If we can remove a prefix sum of size diff, we get it equal to k.

            result += prefixSums.get(diff, 0)
            prefixSums[currentSum] = prefixSums.get(currentSum, 0) + 1

        return result