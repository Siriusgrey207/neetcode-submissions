class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // For > n/k there could be at at most k - 1 number of elements in nums. (2 in our case)
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 1: Find the two most common elements in nums (num1 and num2)
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

        // Step 2: Now that we know that num1 and num2 are the two most frequent elements we resest the counts and
        // we verify the frequencies.
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            if (num == num2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);

        return res;
    }
}