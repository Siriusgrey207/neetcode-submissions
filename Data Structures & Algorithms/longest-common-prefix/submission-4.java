class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String commonPrefix = "";
        String shortestWord = strs[0];

        // Find the shortest Word
        for (String str: strs) {
            if (str.length() < shortestWord.length()) shortestWord = str;
        }
        
        // i - Index of shortest word
        // J - Index of word

        for (int i = 0; i < shortestWord.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortestWord.charAt(i) != strs[j].charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix += shortestWord.charAt(i);
        }

        return commonPrefix;
    }
}