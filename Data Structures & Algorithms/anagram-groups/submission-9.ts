class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {
        // Map of sorted string vs actual string
        const res = {};

        for (let str of strs) {
            const sortedS = str.split("").sort().join();
            if (!res[sortedS]) {
                res[sortedS] = [];
            }
            res[sortedS].push(str);
        }

        return Object.values(res);
    }
}
