class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str: strs) {
            char[] sortedCharArray = str.toCharArray();
            Arrays.sort(sortedCharArray);
            String sortedStr = new String(sortedCharArray);
            anagramsMap.putIfAbsent(sortedStr, new ArrayList());
            anagramsMap.get(sortedStr).add(str);
        }

        return new ArrayList(anagramsMap.values());
    }
}
