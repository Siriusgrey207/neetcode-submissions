class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : (path + "/").toCharArray()) {
            // If we have reached a "/" we will be popping or pushing on to the stack.
            if (c == '/') {
                if (current.toString().equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (!current.toString().equals("") && !current.toString().equals(".")) {
                    stack.push(current.toString());
                }
                current.setLength(0);
            } 
            // Otherwise we are just adding to the current stack element that we are building.
            else {
                current.append(c);
            }
        }

        return "/" + String.join("/", stack);
    }
}