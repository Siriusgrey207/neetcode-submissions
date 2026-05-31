class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 1. Create a char freqiency map of the first string.
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        // 2. Start iterating through the second string.
        int need = count1.size(); // the number of fields that need to match.
        for (int i = 0; i < s2.length(); i++) {
            int current = 0;
            // A map of the second string.
            Map<Character, Integer> count2 = new HashMap<>();

            // 3. Iterate through the substrings of string2.
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                // If there is no match between the corresponding fields, move on to the next iteration.
                if (count1.getOrDefault(c, 0) < count2.get(c)) break;
                if (count1.getOrDefault(c, 0) == count2.get(c)) current++;
                if (current == need) return true;
            }
        }

        return false;
    }
}
