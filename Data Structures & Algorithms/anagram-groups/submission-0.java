class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Create a hash map "sorted string": List of anagrams
        Map<String, List<String>> res = new HashMap<>();

        // Step 2: Loop through each string in the list
        for (String str: strs) 
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            res.putIfAbsent(sortedStr, new ArrayList<>());
            res.get(sortedStr).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
