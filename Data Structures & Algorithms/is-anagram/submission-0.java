class Solution {
    public boolean isAnagram(String s, String t) {
        // Create two character maps of the strings
        Map<Character, Integer> mapOfS = new HashMap<>();
        Map<Character, Integer> mapOfT = new HashMap<>();

        // Loop through the two strings separately and record the character counts.
        for (Character c : s.toCharArray()) {
            mapOfS.put(c, mapOfS.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            mapOfT.put(c, mapOfT.getOrDefault(c, 0) + 1);
        }

        return mapOfS.equals(mapOfT);
    }
}
