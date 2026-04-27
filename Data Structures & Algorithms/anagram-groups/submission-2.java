class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap();

        for (String str: strs) {
            char[] sortedStrChars = str.toCharArray();
            Arrays.sort(sortedStrChars);
            String sortedStr = new String(sortedStrChars);
            anagramsMap.putIfAbsent(sortedStr, new ArrayList<String>());
            anagramsMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
