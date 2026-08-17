class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // At a minimum, the capacity will have to be that of the heaviest weight.
        // At a maximum, the capacity will have to be that of all the weights combined.
        int left = 0;
        int right = 0;

        for (int weight: weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        int res = right;

        // Define a test capacity we will try to ship the weights with.
        // If they can be shipped, try with a lower test capacity.
        // Otherwise try with a higher test capacity.
        while (left <= right) {
            int testCapacity = left + (right - left) / 2;
            if (canShip(weights, days, testCapacity)) {
                res = Math.min(res, testCapacity);
                right = testCapacity - 1;
            } else {
                left = testCapacity + 1;
            }
        }

        return res;
    }

    // Define a helper function that will check if given weights, number of days and
    // a testCapacity, the shipping can be achieved.
    private boolean canShip(int[] weights, int days, int capacityPerShip) {
        int ships = 1;
        int currentCapacity = capacityPerShip;

        for (int weight: weights) {
            int remainingCapacity = currentCapacity - weight;
            // If the ship has reached its capacity limit...
            if (remainingCapacity < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currentCapacity = capacityPerShip;
            }
            currentCapacity -= weight;
        }

        return true;
    }
}