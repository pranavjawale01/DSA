#include<iostream>
#include<stdexcept>

using namespace std;

class TwoStackInOneArray {
private:
    int* array;
    int size;
    int top1;
    int top2;

public:
    TwoStackInOneArray(int capacity) {
        size = capacity;
        array = new int[size];
        top1 = -1;
        top2 = size;
    }

    void push1(int data) {
        if (top1 < top2 - 1) {
            array[++top1] = data;
            cout << "Element added >> " << data << endl;
        } else {
            cout << "Stack 1 Overflow" << endl;
        }
    }

    void push2(int data) {
        if (top1 < top2 - 1) {
            array[--top2] = data;
            cout << "Element added >> " << data << endl;
        } else {
            cout << "Stack 2 Overflow" << endl;
        }
    }

    int pop1() {
        if (top1 >= 0) {
            cout << "Stack 1 Popped element is >> " << array[top1] << endl;
            return array[top1--];
        } else {
            cout << "Stack 1 Underflow" << endl;
            return -1;
        }
    }

    int pop2() {
        if (top2 < size) {
            cout << "Stack 2 Popped element is >> " << array[top2] << endl;
            return array[top2++];
        } else {
            cout << "Stack 2 Underflow" << endl;
            return -1;
        }
    }

    void display() {
        cout << "Stack 1 elements: ";
        for (int i = 0; i <= top1; ++i) {
            cout <<" [" << array[i];
        }
        cout << endl;

        cout << "Stack 2 elements: ";
        for (int i = size - 1; i >= top2; --i) {
            cout << " [" << array[i];
        }
        cout << endl;
    }

    int peek1() {
        if (top1 >= 0) {
            return array[top1];
        } else {
            cout << "Stack 1 is empty" << endl;
            return -1; 
        }
    }

    int peek2() {
        if (top2 < size) {
            return array[top2];
        } else {
            cout << "Stack 2 is empty" << endl;
            return -1;
        }
    }

    int count1() {
        return top1 + 1;
    }

    int count2() {
        return size - top2;
    }

    bool isEmpty1() {
        return top1 == -1;
    }

    bool isEmpty2() {
        return top2 == size;
    }

    bool isFull() {
        return top1 == top2 - 1;
    }

    void destroy() {
        delete[] array;
        array = new int[size];
        top1 = -1;
        top2 = size;
    }
};

int main() {
    int ch = 0, data = 0;
    TwoStackInOneArray x(100);
    do {
        cout << "\n1.Push 1\n2.Push 2\n3.Pop 1\n4.Pop 2\n5.Display\n6.Peek 1\n7.Peek 2\n8.Count 1\n9.Count 2\n10.IsEmpty 1\n11.IsEmpty 2\n12.IsFull\n13.Destroy\n14.Exit\n";
        cout << "Enter choice >> ";
        cin >> ch;
        switch (ch) {
            case 1:
                cout << "Enter data to push >> ";
                cin >> data;
                x.push1(data);
                break;
            case 2:
                cout << "Enter data to push >> ";
                cin >> data;
                x.push2(data);
                break;
            case 3:
                x.pop1();
                break;
            case 4:
                x.pop2();
                break;
            case 5:
                x.display();
                break;
            case 6:
                cout << "Peek 1 result: " << x.peek1() << endl;
                break;
            case 7:
                cout << "Peek 2 result: " << x.peek2() << endl;
                break;
            case 8:
                cout << "Count 1 result: " << x.count1() << endl;
                break;
            case 9:
                cout << "Count 2 result: " << x.count2() << endl;
                break;
            case 10:
                cout << "IsEmpty 1 result: " << (x.isEmpty1() ? "true" : "false") << endl;
                break;
            case 11:
                cout << "IsEmpty 2 result: " << (x.isEmpty2() ? "true" : "false") << endl;
                break;
            case 12:
                cout << "IsFull result: " << (x.isFull() ? "true" : "false") << endl;
                break;
            case 13:
                x.destroy();
                cout << "Array destroyed" << endl;
                break;
            case 14:
                cout << "Exiting program" << endl;
                break;
            default:
                cout << "Invalid choice" << endl;
                break;
        }
    } while (ch != 14);

    return 0;
}