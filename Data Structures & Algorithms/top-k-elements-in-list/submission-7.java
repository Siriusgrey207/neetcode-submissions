class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Map of number - frequency pairs.
        Map<Integer, Integer> counts = new HashMap<>();

        // Frequency array of lists, where index represents frequency.
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialise every list in freq to arrayList
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Record the frequency of each number.
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Put the frequency of each number in the freq array, where the index represents frequency,
        // and the elements in freq[i] represent the corresponding numbers that appear with frequency i
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // Create the response array and initialise an index variable.
        // The index variable keeps track of how many elements we have added in the response array.
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int num: freq[i] ) {
                res[index++] = num;
                if (index == k) return res;
            }
        }

        return res;
    }
}


// Time Complexity: O(n)
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Create a map "number - frequency" pairs
//         Map<Integer, Integer> count = new HashMap<>();

//         // Create a list where the index represents frequency and the value represents the corresponding number(s).
//         List<Integer>[] freq = new List[nums.length + 1];

//         // Initialise the Lists in the freq array to array lists.
//         for (int i = 0; i < freq.length; i++) {
//             freq[i] = new ArrayList<>();
//         }

//         // Record the frequency of each number in the nums array:
//         for (int num : nums) {
//             count.put(num, count.getOrDefault(num, 0) + 1);
//         }

//         // Loop through the entries in the map, and append the corresponding number to the corresponding frequency.
//         for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
//             freq[entry.getValue()].add(entry.getKey());
//         }

//         // Create the response array of k elements.
//         int[] res = new int[k];
//         int index = 0; // Will keep track if we have reached k elements.

//         // Loop backwards from the freq array.
//         for (int i = freq.length - 1; i > 0 && index < k; i--) {
//             // Copy every freq[i] entry to res and once the we have copied k elements into res, we have completed the task and return res.
//             for (int n : freq[i]) {
//                 res[index++] = n;
//                 if (index == k) return res;
//             }
//         }

//         return res;
//     }
// }
