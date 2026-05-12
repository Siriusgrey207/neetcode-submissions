class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // For > n/k there could be at at most k - 1 number of elements in nums. (2 in our case)
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 1: Use the counts to find the two most common elements (num1 and num2)
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                num1 = num;
            } else if (count2 == 0) {
                count2++;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Reset count1 and count2 and find the actual frequency of num1 and num2
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            if (num == num2) count2++;
        }

        // Step 3: Check if the frequency is large enough to be added to res.
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);

        return res;
    }
}