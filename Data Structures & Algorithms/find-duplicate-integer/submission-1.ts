class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findDuplicate(nums: number[]): number {
        let seen: Set<number> = new Set<number>();

        for (const num of nums) {
            if (seen.has(num)) {
                return num;
            }

            seen.add(num);
        }

        return -1;
    }
}
