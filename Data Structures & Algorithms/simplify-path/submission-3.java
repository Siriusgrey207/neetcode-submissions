class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : (path + "/").toCharArray()) {
            if (c == '/') {
                if (current.toString().equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (!current.toString().equals("") && !current.toString().equals(".")) {
                    stack.push(current.toString());
                }
                current.setLength(0);
            }
            else {
                current.append(c);
            }
        }

        return "/" + String.join("/", stack);
    }
}