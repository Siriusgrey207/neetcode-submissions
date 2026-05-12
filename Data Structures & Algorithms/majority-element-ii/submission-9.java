class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // There are exactly n - 1 number of elements that appear at a a frequency larger than n / 3;
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                num1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);

        return res;
    }
}