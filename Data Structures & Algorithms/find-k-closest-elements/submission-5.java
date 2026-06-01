class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Define the left and right pointers.
        int left = 0;
        int right = arr.length - 1;

        // Loop until we have reached the correct window size.
        while (right - left >= k) {
            // Calculate the absolute difference between x and the elements the two pointers are pointing at.
            int leftDiff = Math.abs(x - arr[left]);
            int rightDiff = Math.abs(x - arr[right]);

            // Move the correct pointer, whilst preferring the left, smaller elements.
            if (leftDiff <= rightDiff) {
                right--;
            } else {
                left++;
            }
        }

        // Construct the response list and add the elements between the two windows.
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}