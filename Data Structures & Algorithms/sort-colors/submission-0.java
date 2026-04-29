class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        // Create the counters for the integers
        int reds = 0; // for 0 (red)
        int whites = 0; // for 1 (white)
        int blues = 0; // for blue

        // Loop through nums and count occurrences
        for (int num: nums) {
            if (num == 0) reds++;
            if (num == 1) whites++;
            if (num == 2) blues++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (reds > 0) {
                nums[i] = 0;
                reds--;
                continue;
            }

            if (whites > 0) {
                nums[i] = 1;
                whites--;
                continue;
            }

            nums[i] = 2;
            blues--;
        }
    }
}