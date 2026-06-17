class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            
            anagramsMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramsMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
