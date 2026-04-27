// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String firstword = strs[0];
        // for every letter in the first word...
        for (int i = 0; i < firstword.length(); i++)
        {
            // for every word in the list of words
            for (String str: strs)
            {
                // If the index is out of bounds, or the letters are different...
                if (i == str.length() || firstword.charAt(i) != str.charAt(i))
                {
                    return firstword.substring(0, i);
                }
            }
        }

        return firstword;
    }
}