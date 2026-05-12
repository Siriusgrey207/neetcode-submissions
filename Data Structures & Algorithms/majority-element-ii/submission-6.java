// Boyer-Moore voting implementation using a map.
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // integer <-> frequency counts
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);

            if (counts.size() > 2) {
                Map<Integer, Integer> newCounts = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                    if (entry.getValue() > 1) {
                        newCounts.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                counts = newCounts;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int key : counts.keySet()) {
            int frequency = 0;
            for (int num : nums) {
                if (key == num) frequency++;
            }
            if (frequency > nums.length / 3) res.add(key);
        }

        return res;
    }
}

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         Map<Integer, Integer> count = new HashMap<>();

//         for (int num : nums) {
//             count.put(num, count.getOrDefault(num, 0) + 1);

//             if (count.size() > 2) {
//                 Map<Integer, Integer> newCount = new HashMap<>();
//                 for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
//                     if (entry.getValue() > 1) {
//                         newCount.put(entry.getKey(), entry.getValue() - 1);
//                     }
//                 }
//                 count = newCount;
//             }
//         }

//         List<Integer> res = new ArrayList<>();
//         for (int key : count.keySet()) {
//             int frequency = 0;
//             for (int num : nums) {
//                 if (num == key) frequency++;
//             }
//             if (frequency > nums.length / 3) res.add(key);
//         }

//         return res;
//     }
// }