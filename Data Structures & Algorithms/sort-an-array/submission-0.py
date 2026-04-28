# "the base case" - When arr consist of a single element.

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:


        def merge(arr, left, middle, right):
            leftArrCopy = arr[left : middle + 1]
            rightArrCopy = arr[middle + 1 : right + 1]
            # i points to the beginning of arr, 
            # j points to the beginning of leftArrCopy
            # k points to the beginning of rightArrCopy
            i, j, k = left, 0, 0

            while j < len(leftArrCopy) and k < len(rightArrCopy):
                if leftArrCopy[j] <= rightArrCopy[k]:
                    arr[i] = leftArrCopy[j]
                    j += 1
                else:
                    arr[i] = rightArrCopy[k]
                    k += 1
                
                i += 1

            while j < len(leftArrCopy):
                nums[i] = leftArrCopy[j]
                j += 1
                i += 1

            while k < len(rightArrCopy):
                nums[i] = rightArrCopy[k]
                k += 1
                i += 1
                    

        
        def mergeSort(arr, left, right):
            # If the left and right pointer are the same, we have reached our base case.
            if left == right:
                return arr

            # Get the middle element using integer division.
            middle = (left + right) // 2

            # Call the function recursively until we reach the base case.
            mergeSort(arr, left, middle)
            mergeSort(arr, middle + 1, right)

            # Up to this point we have been performing the division of the array into
            # smaller and smaller subarrays. Now it is time to merge the subarrays together.

            merge(arr, left, middle, right)

            return arr

        return mergeSort(nums, 0, len(nums) - 1)
