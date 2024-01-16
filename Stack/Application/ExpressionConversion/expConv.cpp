#include <iostream>
#include <stack>
#include <cmath>

using namespace std;

bool isOperand(char ch) {
    return (ch >= '0' && ch <= '9');
}

bool isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
}

int getPrecedence(char ch) {
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

string infixToPostfix(const string& infix) {
    stack<char> s;
    string postfix = "";
    
    for (char ch : infix) {
        if (isOperand(ch)) {
            postfix += ch;
        } else if (ch == '(') {
            s.push(ch);
        } else if (ch == ')') {
            while (!s.empty() && s.top() != '(') {
                postfix += s.top();
                s.pop();
            }
            s.pop();
        } else if (isOperator(ch)) {
            while (!s.empty() && getPrecedence(s.top()) >= getPrecedence(ch)) {
                postfix += s.top();
                s.pop();
            }
            s.push(ch);
        }
    }
    while (!s.empty()) {
        postfix += s.top();
        s.pop();
    }
    return postfix;
}

string infixToPrefix(const string& infix) {
    string reversedInfix = "";
    for (int i = infix.length() - 1; i >= 0; --i) {
        if (infix[i] == '(') {
            reversedInfix += ')';
        } else if (infix[i] == ')') {
            reversedInfix += '(';
        } else {
            reversedInfix += infix[i];
        }
    }
    string postfix = infixToPostfix(reversedInfix);
    string prefix = "";
    for (int i = postfix.length() - 1; i >= 0; --i) {
        prefix += postfix[i];
    }

    return prefix;
}

int evaluatePostfix(const string& postfix) {
    stack<int> s;
    for (char ch : postfix) {
        if (isOperand(ch)) {
            s.push(ch - '0');
        } else if (isOperator(ch)) {
            int operand2 = s.top();
            s.pop();
            int operand1 = s.top();
            s.pop();
            switch (ch) {
                case '+':
                    s.push(operand1 + operand2);
                    break;
                case '-':
                    s.push(operand1 - operand2);
                    break;
                case '*':
                    s.push(operand1 * operand2);
                    break;
                case '/':
                    s.push(operand1 / operand2);
                    break;
                case '^':
                    s.push(pow(operand1, operand2));
                    break;
            }
        }
    }
    return s.top();
}

int evaluatePrefix(const string& prefix) {
    stack<int> s;

    for (int i = prefix.length() - 1; i >= 0; --i) {
        if (isOperand(prefix[i]))
            s.push(prefix[i] - '0');
        else if (isOperator(prefix[i])) {
            int operand1 = s.top();
            s.pop();
            int operand2 = s.top();
            s.pop();

            switch (prefix[i]) {
                case '+':
                    s.push(operand1 + operand2);
                    break;
                case '-':
                    s.push(operand1 - operand2);
                    break;
                case '*':
                    s.push(operand1 * operand2);
                    break;
                case '/':
                    s.push(operand1 / operand2);
                    break;
                case '^':
                    s.push(pow(operand1, operand2));
                    break;
            }
        }
    }

    return s.top();
}

int main() {
    string infixExpression;
    cout << "Enter infix expression: ";
    getline(cin, infixExpression);

    string postfixExpression = infixToPostfix(infixExpression);
    cout << "Postfix expression: " << postfixExpression << endl;

    string prefixExpression = infixToPrefix(infixExpression);
    cout << "Prefix expression: " << prefixExpression << endl;

    int result = evaluatePostfix(postfixExpression);
    cout << "Result of postfix expression: " << result << endl;

    result = evaluatePrefix(prefixExpression);
    cout << "Result of prefix expression: " << result << endl;

    return 0;
}