class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        // The set will contains the chars between the two pointers.
        int left = 0;
        int res = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                res = Math.max(charSet.size(), res);
            } else {
                charSet.remove(s.charAt(left));
                left++;
                right--;
            }
        }

        return res;
    }
}
