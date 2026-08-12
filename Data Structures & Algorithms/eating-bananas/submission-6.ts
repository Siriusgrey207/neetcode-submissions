class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles: number[], h: number): number {
        // Two pointers that represent the range of possible bananas / hour eaten.
        let left: number = 1;
        let right: number = Math.max(...piles);
        let res = right;

        while (left <= right) {
            const k: number = Math.floor((left + right) / 2);
            let totalTime = 0;

            for (const pile of piles) {
                totalTime += Math.ceil(pile / k);
            }   

            if (totalTime <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return res;
    }
}
