// class Solution {
//     public boolean isPalindrome(String s) {
//         String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").trim();

//         int left = 0;
//         int right = cleanedString.length() - 1;

//         while (left <= right) {
//             char leftChar = Character.toLowerCase(cleanedString.charAt(left++));
//             char rightChar = Character.toLowerCase(cleanedString.charAt(right--));
//             if (leftChar != rightChar) return false;
//         }

//         return true;
//     }
// }

public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alpha-numeric chars.
            while (left < right && !alphaNum(s.charAt(left))) {
                left++;
            }
            while (right > left && !alphaNum(s.charAt(right))) {
                right--;
            }
            // Compare lowercase chars.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}