class Solution {
    canShip(weights: number[], capacityPerShip: number, days: number): boolean {
        let ships: number = 1;
        let currentCapacity = capacityPerShip;

        for (const weight of weights) {
            if (currentCapacity - weight < 0) {
                ships++;
                currentCapacity = capacityPerShip;
            }
            currentCapacity -= weight;
        }
        return ships <= days;
    }

    /**
     * @param {number[]} weights
     * @param {number} days
     * @return {number}
     */
    shipWithinDays(weights: number[], days: number): number {
        let left: number = Math.max(...weights);
        let right: number = 0;
        weights.map((weight: number) => right += weight);
        let res: number = right;

        while (left <= right) {
            let testCapacity: number = Math.floor(left + (right - left) / 2);

            // Check if given this capacity all the weights can be shipped.
            if (this.canShip(weights, testCapacity, days)) {
                res = Math.min(res, testCapacity);
                right = testCapacity - 1;
            } else {
                left = testCapacity + 1;
            }
        }

        return res;
    }
}
