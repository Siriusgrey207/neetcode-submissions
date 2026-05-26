class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            int remain = limit - people[r--];
            result++;
            if (l <= r && remain >= people[l]) {
                l++;
            }
        }

        return result;
    }
}