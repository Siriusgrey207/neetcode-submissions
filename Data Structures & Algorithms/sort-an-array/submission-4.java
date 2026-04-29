class Solution {
    public int[] sortArray(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        mergeSort(numsCopy);
        return numsCopy;
    }

    // 
    public void mergeSort(int[] nums) {
        divideToBaseCase(nums, 0, nums.length - 1);
    }

    public void divideToBaseCase(int[] nums, int left, int right) {
        // If this is true we have reached our base case.
        if (left >= right) return;

        // Get the mid point a call the function recursively to reach the base case.
        int mid = left + (right - left) / 2;
        divideToBaseCase(nums, left, mid);
        divideToBaseCase(nums, mid + 1, right);

        // Once we have reached the base case, we can start merging in place.
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Determine the size of the left array and right arrays.
        int nLeft = (mid + 1) - left;
        int nRight = right - mid;

        // Initialise two empty arrays with the appropriate lengths.
        int[] leftArr = new int[nLeft];
        int[] rightArr = new int[nRight];

        // Copy the elements into the two arrays.
        System.arraycopy(nums, left, leftArr, 0, nLeft);
        System.arraycopy(nums, mid + 1, rightArr, 0, nRight);

        // Create two points for the two subarrays and 1 points that will be pointing at the start of nums.
        int i = 0;
        int j = 0;
        int k = left;

        // Compare the number being pointed to from the two subarrays and move the appropriate pointers afterwards.
        while (i < nLeft && j < nRight) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i += 1;
            } else {
                nums[k] = rightArr[j];
                j += 1;
            }

            k += 1;
        }

        // Whatever numbers are left from one of the two subarrays have already been sorted and need to be added at the end of the nums array.
        while (i < nLeft) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < nRight) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }
}