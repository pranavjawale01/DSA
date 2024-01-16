package DSA.Stack.Application.ExpressionConversion;

import java.util.Stack;

public class expConv {
    
    static boolean isOperand(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    static int getPrecedence(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    static String infixToPrefix(String infix) {
        StringBuilder reversedInfix = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; --i) {
            if (infix.charAt(i) == '(') {
                reversedInfix.append(')');
            } else if (infix.charAt(i) == ')') {
                reversedInfix.append('(');
            } else {
                reversedInfix.append(infix.charAt(i));
            }
        }

        String postfix = infixToPostfix(reversedInfix.toString());
        StringBuilder prefix = new StringBuilder();
        for (int i = postfix.length() - 1; i >= 0; --i) {
            prefix.append(postfix.charAt(i));
        }

        return prefix.toString();
    }

    static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (isOperand(ch)) {
                stack.push(ch - '0');
            } else if (isOperator(ch)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; --i) {
            if (isOperand(prefix.charAt(i)))
                stack.push(prefix.charAt(i) - '0');
            else if (isOperator(prefix.charAt(i))) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (prefix.charAt(i)) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String infixExpression = "3 + (4 * 2) / (1 - 5)^2";
        System.out.println("Infix expression: " + infixExpression);

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Prefix expression: " + prefixExpression);

        int resultPostfix = evaluatePostfix(postfixExpression);
        System.out.println("Result of postfix expression: " + resultPostfix);

        int resultPrefix = evaluatePrefix(prefixExpression);
        System.out.println("Result of prefix expression: " + resultPrefix);
    }
}