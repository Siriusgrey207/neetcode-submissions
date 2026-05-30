class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Frequency char map of the s1 string.
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        // Variable that indicates how many fields should be in the second map.
        int need = count1.size();
        for (int i = 0; i < s2.length(); i++) {
            // Create the second counts map
            Map<Character, Integer> count2 = new HashMap<>();
            int current = 0; // Number of fields in count2 that have same values as their equivalent in count1.

            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                if (count1.getOrDefault(c, 0) < count2.get(c)) {
                    break;
                }

                // Increment current if a given char has the same frequency in the two maps.
                if (count1.getOrDefault(c, 0) == count2.get(c)) {
                    current++;
                }

                if (current == need) return true;
            }
        }

        return false;
    }
}
