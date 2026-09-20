class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = 0, 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            # If this is true, we are in the loop
            if fast == slow:
                break
        
        # Create a second slow pointer
        slowTwo = 0
        while True:
            slow = nums[slow]
            slowTwo = nums[slowTwo]
            if slow == slowTwo:
                break;
        
        return slow;