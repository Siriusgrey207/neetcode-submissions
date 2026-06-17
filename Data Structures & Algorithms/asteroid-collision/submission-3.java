class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            // While the current asteroid is moving to the left and the one on the top of the
            // stack is moving to the right...
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sizeDiff = a + stack.peek();

                if (sizeDiff < 0) {
                    stack.pop();
                } else if (sizeDiff == 0) {
                    stack.pop();
                    a = 0;
                } else {
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}