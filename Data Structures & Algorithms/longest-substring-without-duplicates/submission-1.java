class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int left = 0;
        Set<Character> charSet = new HashSet<>();
        int longestSubLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                longestSubLength = Math.max(charSet.size(), longestSubLength);
            } else {
                charSet.remove(s.charAt(left));
                left++;
                right--;
            }
        }

        return longestSubLength;
    }
}
