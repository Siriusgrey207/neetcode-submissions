class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);
            anagramsMap.putIfAbsent(sortedString, new ArrayList<>());
            anagramsMap.get(sortedString).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
