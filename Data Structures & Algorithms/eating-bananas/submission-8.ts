class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles: number[], h: number): number {
        let left: number = 1;
        let right: number = Math.max(...piles);
        let res = right;

        while (left <= right) {
            // Current rate of bananas eaten.
            const k: number = Math.floor(left + (right - left) / 2);
            let totalTime: number = 0;

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
