class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Map of closing to opening brackets.
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            // If the bracket is a closing one...
            if (closeToOpen.containsKey(c)) {
                // We expect the one at the top of the stack to be an opening one of the corresponding type.
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            // If the bracket is an opening one, we just push it on the stack.
            } else {
                stack.push(c);
            }
        }

        // At the end, the stack should be empty.
        return stack.isEmpty();
    }
}
