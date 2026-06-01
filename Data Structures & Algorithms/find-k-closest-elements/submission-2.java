class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            int diffLeft = Math.abs(x - arr[left]);
            int diffRight = Math.abs(x - arr[right]);

            if (diffLeft <= diffRight) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}