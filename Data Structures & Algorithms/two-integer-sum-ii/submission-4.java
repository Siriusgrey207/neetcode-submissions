public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)) {
                return new int[] { mp.get(tmp), i + 1 };
            }
            mp.put(numbers[i], i + 1);
        }

        return new int[0];
    }
}

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int left = 0;
//         int right = numbers.length - 1;
//         int current = numbers[left] + numbers[right];

//         while (current != target) {
//             if (current > target) {
//                 right--;
//             } else {
//                 left++;
//             }
//             current = numbers[left] + numbers[right];
//         }

//         return new int[] { left + 1, right + 1 };
//     }
// }
