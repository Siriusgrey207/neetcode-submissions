class Solution {
    public int characterReplacement(String s, int k) {
        // Add all the chars of s into the charSet.
        int res = 0;
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        // Loop through every char in th set:
        for (char c : charSet) {
            int count = 0; // number of c characters in the current window
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                // Increment count if s.charAt(right) == c
                if (s.charAt(right) == c) {
                    count++;
                }

                // If there are more non-c characters than k in the current window, move the window left.
                while ((right - left + 1) - count > k) {
                    if (s.charAt(left) == c) {
                        count--;
                    }
                    left++;
                }

                res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }
}
