class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        // Create a frequency map of the first word.
        std::unordered_map<char, int> count1 {};
        for (char c : s1) {
            count1[c]++;
        }

        // Initialise a variable with the information about the number of fields in first map.
        std::size_t need { count1.size() };
        for (int i { 0 }; i < s2.length(); i++) {
            std::unordered_map<char, int> count2 {};
            std::size_t current { 0 };
            for (int j { i }; j < s2.length(); j++){
                char c = s2[j];
                count2[c]++;

                if (count1[c] < count2[c]) {
                    break;
                }

                if (count1[c] == count2[c]) {
                    current++;
                }

                if (current == need) return true;
            }
        }

        return false;
    }
};
