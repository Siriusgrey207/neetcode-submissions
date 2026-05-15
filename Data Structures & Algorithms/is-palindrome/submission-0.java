class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").trim();

        int left = 0;
        int right = cleanedString.length() - 1;

        while (left <= right) {
            char leftChar = Character.toLowerCase(cleanedString.charAt(left++));
            char rightChar = Character.toLowerCase(cleanedString.charAt(right--));
            if (leftChar != rightChar) return false;
        }        
        return true;
    }
}
