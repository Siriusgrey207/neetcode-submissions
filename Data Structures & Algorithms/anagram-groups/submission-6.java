class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] strCharArr = str.toCharArray();
            Arrays.sort(strCharArr);
            String sortedStr = new String(strCharArr);
            anagramsMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramsMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
