class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        // i - letter index of the first word
        for (int i = 0; i < strs[0].length(); i++)
        {
            for (String str: strs) 
            {
                if (i == str.length() || strs[0].charAt(i) != str.charAt(i))
                {
                    return str.substring(0, i);
                }
            }
        }
        return strs[0];
    }
}