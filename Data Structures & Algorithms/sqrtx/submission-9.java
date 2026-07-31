class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            long squared = (long) middle * middle;

            if (squared > x) {
                right = middle - 1;
            } else if (squared < x) {
                left = middle + 1;
                res = middle;
            } else {
                return middle;
            }
        }

        return res;
    }
}