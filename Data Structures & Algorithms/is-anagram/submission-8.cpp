class Solution {
public:
    bool isAnagram(string s, string t) {
        // Anagram words needs to be of the same length.
        if (s.length() != t.length()) return false;

        int counts[26] {};

        for (std::size_t i { 0 }; i < s.length(); i++) {
            counts[s[i] - 'a']++;
            counts[t[i] - 'a']--;
        }

        for (int val : counts) {
            if (val != 0) return false;
        }
        return true;
    }
};
