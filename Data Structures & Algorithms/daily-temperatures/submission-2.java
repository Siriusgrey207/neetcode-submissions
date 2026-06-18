class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int[] topPair = stack.pop();
                res[topPair[1]] = i - topPair[1];
            }

            stack.push(new int[] { temperature, i });
        }

        return res;
    }
}
