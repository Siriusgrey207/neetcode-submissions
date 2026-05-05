class Solution {
    // Create a StringBuilder instance. For every string we add the string to the stringBuilder in
    // the following format:
    // *string length* + "#" + "string"
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str: strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int wordLength = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            result.add(str.substring(i, i + wordLength));
            i += wordLength;
        }

        return result;
    }
}
