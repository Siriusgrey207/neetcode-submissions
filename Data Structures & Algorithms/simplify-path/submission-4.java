class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : (path + "/").toCharArray()) {
            if (c == '/') {
                if (stringBuilder.toString().equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (!stringBuilder.toString().equals("") && !stringBuilder.toString().equals(".")) {
                    stack.push(stringBuilder.toString());
                }

                stringBuilder.setLength(0);
            }
            else {
                stringBuilder.append(c);
            }
        }

        return "/" + String.join("/", stack);
    }
}