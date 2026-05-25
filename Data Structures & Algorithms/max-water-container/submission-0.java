class Solution {
    public int maxArea(int[] heights) {
        // Two pointers that point at the first bar and the last bar.
        int j = heights.length - 1;
        int i = 0;

        int maxVolume = 0;

        while (i < j) {
            int currentVolume = (j - i) * Math.min(heights[i], heights[j]);
            if (currentVolume > maxVolume)
                maxVolume = currentVolume;
            
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxVolume;
    }
}
