class Solution {
    /**
     * @param {number[]} nums
     * @param {number} val
     * @return {number}
     */
    removeElement(nums: number[], val: number): number {
        const tempArr: number[] = [];
        for (const num of nums) {
            if (num !== val) {
                tempArr.push(num);
            }
        }

        for (let i = 0; i < tempArr.length; i++) {
            nums[i] = tempArr[i];
        }

        return tempArr.length;
    }
}
