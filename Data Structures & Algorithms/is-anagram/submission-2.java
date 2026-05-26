public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}


// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;

//         // Create two character maps of the strings
//         Map<Character, Integer> countS = new HashMap<>();
//         Map<Character, Integer> countT = new HashMap<>();

//         // Loop through the two strings separately and record the character counts.
//         for (int i = 0; i < s.length(); i++) {
//             countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
//             countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
//         }

//         return countS.equals(countT);
//     }
// }
