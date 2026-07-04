class Solution:
    def decodeString(self, s: str) -> str:
        stack = []

        for i in range(len(s)):
            # As long as the current char is not an opening bracket, add it to the stack.
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""

                # Continue popping and adding to the beginning of the substr
                # until the top of the stack is an opening bracket.
                while stack[-1] != "[":
                    substr = stack.pop() + substr

                # Required to pop the opening bracket.
                stack.pop()

                # Get the digit before the opening bracket and multiply the string witin the brackets
                # by k and push it on the stack.
                k = ""
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                
                stack.append(int(k) * substr)

        return "".join(stack)

