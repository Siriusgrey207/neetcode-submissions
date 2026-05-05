class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder encoded = new StringBuilder();
        for (String str: strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();

        List<String> words = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int wordLength = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            words.add(str.substring(i, i + wordLength));
            i += wordLength;
        }
        return words;
    }
}
