class Solution {
    /**
     * @param {string[]} strs
     * @return {string}
     */
    longestCommonPrefix(strs: string[]): string {
        let longest = "";
        for (let i = 0; i < strs[0].length; i++) {
            for (let str of strs) {
                if (i === str.length || str[i] !== strs[0][i]) {
                    return longest;
                }
            }
            longest += strs[0][i];
        }

        return longest
    }
}
