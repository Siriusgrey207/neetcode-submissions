class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        // Create a frequency map of the first word.
        std::unordered_map<char, int> count1 {};
        for (char c : s1) {
            count1[c]++;
        }

        // Variable that stores the number of fields in the first map.
        std::size_t need { count1.size() };
        for (std::size_t i { 0 }; i < s2.length(); i++) {
            // Initialise the second frequency map.
            std::unordered_map<char, int> count2 {};
            std::size_t current { 0 };

            for (std::size_t j { i }; j < s2.length(); j++) {
                char c = s2[j];
                count2[c]++;

                if (count1[c] < count2[c]) break;
                if (count1[c] == count2[c]) current++;
                if (current == need) return true;
            }
        }

        return false;
    }
};
