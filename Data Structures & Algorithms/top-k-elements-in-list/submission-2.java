class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return new int[] { nums[0] };

        // Create a map of number - frequency pairs.
        Map<Integer, Integer> count = new HashMap<>();

        // Record the frequency of each number.
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        } 

        // Create a List of arrays, each array represents [frequency, number]
        List<int[]> frequencyNumberList = new ArrayList<>();

        // From the entry set of the map, create an array and add it to arr.
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            frequencyNumberList.add(new int[] { entry.getValue(), entry.getKey() });
        }

        // Now sort the arrayList based on the frequency
        frequencyNumberList.sort((a, b) -> b[0] - a[0]);

        // Create a new array with a length k which will store the top frequency elements.
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = frequencyNumberList.get(i)[1];
        }
        return res;
    }
}



// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         if (nums.length == 1) return new int[] { nums[0] };

//         // Create the list of number - frequency pairs.
//         Map<Integer, Integer> count = new HashMap<>();

//         // Record and update the frequency of each number.
//         for (int num: nums) {
//             count.put(num, count.getOrDefault(num, 0) + 1);
//         }

//         // Create a list of arrays, each array represents [frequency, number]
//         List<int[]> arr = new ArrayList<>();
//         for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
//             arr.add(new int[] { entry.getValue(), entry.getKey() });
//         }
//         arr.sort((a, b) -> b[0] - a[0]);

//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) {
//             res[i] = arr.get(i)[1];
//         }
//         return res;
//     }
// }
