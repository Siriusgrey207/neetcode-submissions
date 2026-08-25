class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            # If the target equals the value at the mid index, return the mid index.
            mid = (left + right) // 2
            if target == nums[mid]:
                return mid
            
            # Check if mid is in the left-sorted portion.
            if nums[left] <= nums[mid]:
                if target > nums[mid] or target < nums[left]:
                    left = mid + 1
                else:
                    right = mid - 1
                
            # Otherwise we are in the right-sorted portion.
            else:
                if target < nums[mid] or target > nums[right]:
                    right = mid - 1
                else:
                    left = mid + 1
        
        return -1;