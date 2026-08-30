class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        left = max(nums)
        right = sum(nums)
        res = right

        while left <= right:
            mid = left + (right - left) // 2

            if self.canSplit(mid, nums, k):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return res
    
    # largest - The largest sum a given subarray could be.
    def canSplit(self, largest, nums, k):
        subarray = 0
        currentSum = 0

        for n in nums:
            currentSum += n

            if currentSum > largest:
                subarray += 1
                currentSum = n
        
        return subarray + 1 <= k
            
            