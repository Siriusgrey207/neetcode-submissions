class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x;
        int res = 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            long square = (long) middle * middle;

            if (square == x) {
                return middle;
            } else if (square < x) {
                res = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return res;
    }
}