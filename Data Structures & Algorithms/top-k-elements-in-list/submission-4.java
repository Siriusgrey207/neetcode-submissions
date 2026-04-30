// Time Complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a map "number - frequency" pairs
        Map<Integer, Integer> count = new HashMap<>();

        // Create a list where the index represents frequency and the value represents the corresponding number(s).
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialise the Lists in the freq array to array lists.
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Record the frequency of each number in the nums array:
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Loop through the entries in the map, and append the corresponding number to the corresponding frequency.
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) return res;
            }
        }

        return res;
    }
}

// Time Complexity: O(nlog_10(n)) time
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         if (nums.length == 1) return new int[] { nums[0] };

//         // Create a map of number - frequency pairs.
//         Map<Integer, Integer> count = new HashMap<>();

//         // Record the frequency of each number.
//         for (int num: nums) {
//             count.put(num, count.getOrDefault(num, 0) + 1);
//         } 

//         // Create a List of arrays, each array represents [frequency, number]
//         List<int[]> frequencyNumberList = new ArrayList<>();

//         // From the entry set of the map, create an array and add it to arr.
//         for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
//             frequencyNumberList.add(new int[] { entry.getValue(), entry.getKey() });
//         }

//         // Now sort the arrayList based on the frequency
//         frequencyNumberList.sort((a, b) -> b[0] - a[0]);

//         // Create a new array with a length k which will store the top frequency elements.
//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) {
//             res[i] = frequencyNumberList.get(i)[1];
//         }
//         return res;
//     }
// }
