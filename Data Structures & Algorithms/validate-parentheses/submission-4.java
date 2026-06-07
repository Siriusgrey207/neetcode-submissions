class Solution {
    public boolean isValid(String s) {
        // Create a stack where the opening brackets will be put.
        Stack<Character> stack = new Stack<>();

        // A map of closing to opening brackets.
        Map<Character, Character> closeToOpen = Map.of('}', '{', ')', '(', ']', '[');

        for (char c : s.toCharArray()) {
            // If the bracket is a closing one, try mappingit to a closing one.
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            // If the bracket is an opening one, add it on the stack.
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
