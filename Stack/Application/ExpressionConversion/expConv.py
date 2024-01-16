class expConv:

    @staticmethod
    def is_operand(ch):
        return '0' <= ch <= '9'

    @staticmethod
    def is_operator(ch):
        return ch in ['+', '-', '*', '/', '^']

    @staticmethod
    def get_precedence(ch):
        if ch == '^':
            return 3
        elif ch == '*' or ch == '/':
            return 2
        elif ch == '+' or ch == '-':
            return 1
        else:
            return 0

    @staticmethod
    def infix_to_postfix(infix):
        stack = []
        postfix = ""

        for ch in infix:
            if expConv.is_operand(ch):
                postfix += ch
            elif ch == '(':
                stack.append(ch)
            elif ch == ')':
                while stack and stack[-1] != '(':
                    postfix += stack.pop()
                stack.pop()  # Pop '('
            elif expConv.is_operator(ch):
                while stack and expConv.get_precedence(stack[-1]) >= expConv.get_precedence(ch):
                    postfix += stack.pop()
                stack.append(ch)

        while stack:
            postfix += stack.pop()

        return postfix

    @staticmethod
    def infix_to_prefix(infix):
        reversed_infix = ""
        for i in range(len(infix) - 1, -1, -1):
            if infix[i] == '(':
                reversed_infix += ')'
            elif infix[i] == ')':
                reversed_infix += '('
            else:
                reversed_infix += infix[i]

        postfix = expConv.infix_to_postfix(reversed_infix)
        prefix = ""
        for i in range(len(postfix) - 1, -1, -1):
            prefix += postfix[i]

        return prefix

    @staticmethod
    def evaluate_postfix(postfix):
        stack = []

        for ch in postfix:
            if expConv.is_operand(ch):
                stack.append(int(ch))
            elif expConv.is_operator(ch):
                operand2 = stack.pop()
                operand1 = stack.pop()
                if ch == '+':
                    stack.append(operand1 + operand2)
                elif ch == '-':
                    stack.append(operand1 - operand2)
                elif ch == '*':
                    stack.append(operand1 * operand2)
                elif ch == '/':
                    stack.append(operand1 / operand2)
                elif ch == '^':
                    stack.append(operand1 ** operand2)

        return stack.pop()

    @staticmethod
    def evaluate_prefix(prefix):
        stack = []

        for i in range(len(prefix) - 1, -1, -1):
            if expConv.is_operand(prefix[i]):
                stack.append(int(prefix[i]))
            elif expConv.is_operator(prefix[i]):
                operand1 = stack.pop()
                operand2 = stack.pop()
                if prefix[i] == '+':
                    stack.append(operand1 + operand2)
                elif prefix[i] == '-':
                    stack.append(operand1 - operand2)
                elif prefix[i] == '*':
                    stack.append(operand1 * operand2)
                elif prefix[i] == '/':
                    stack.append(operand1 / operand2)
                elif prefix[i] == '^':
                    stack.append(operand1 ** operand2)

        return stack.pop()


if __name__ == "__main__":
    infix_expression = "3 + (4 * 2) / (1 - 5)^2"
    print("Infix expression:", infix_expression)

    postfix_expression = expConv.infix_to_postfix(infix_expression)
    print("Postfix expression:", postfix_expression)

    prefix_expression = expConv.infix_to_prefix(infix_expression)
    print("Prefix expression:", prefix_expression)

    result_postfix = expConv.evaluate_postfix(postfix_expression)
    print("Result of postfix expression:", result_postfix)

    result_prefix = expConv.evaluate_prefix(prefix_expression)
    print("Result of prefix expression:", result_prefix)