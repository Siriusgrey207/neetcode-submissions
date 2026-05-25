class Solution {
    public int maxArea(int[] heights) {
        // Two pointers that point at the first and last columns.
        int i = 0;
        int j = heights.length - 1;

        int maxVolume = 0;
        int currentVolume = 0;

        while (i < j) {
            currentVolume = (j - i) * Math.min(heights[i], heights[j]);
            if (currentVolume > maxVolume)
                maxVolume = currentVolume;

            if (heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return maxVolume;
    }
}
