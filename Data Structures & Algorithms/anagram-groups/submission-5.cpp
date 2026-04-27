#include <unordered_map>

class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        // 1. Create the anagrams Map
        std::unordered_map<string, std::vector<std::string>> anagramsMap {};

        // 2. Map the words based on their sorted version.
        for (const std::string& str: strs) {
            std::string sortedStr { str };
            std::sort(sortedStr.begin(), sortedStr.end());
            anagramsMap[sortedStr].push_back(str);
        }

        // 3. Create the result vector and push the vector results in it.
        std::vector<std::vector<std::string>> result {};

        // 4. Add every list of anagrams from the anagrams map to result.
        for (const std::pair<const std::string&, std::vector<std::string>>& pair: anagramsMap)
            result.push_back(pair.second);

        // 5. Return the result
        return result;
    }
};
