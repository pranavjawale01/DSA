#include <iostream>
using namespace std;

#define MAX_SIZE 100

class ArrayStack {
private:
    int top;
    int arr[MAX_SIZE] = {0};

public:
    ArrayStack() {
        top = -1;
    }

    void push() {
        if (top >= MAX_SIZE - 1) {
            cout<<"Stack is Full !!!";
            return;
        }
        int value = 0;
        cout<<"Enter the value to push >> ";
        cin>>value;
        arr[++top] = value;
    }
    
    void pop() {
        if (top < 0) {
            cout<<"Stack is Empty";
            return;
        }
        cout<<"Top Element Popped "<<arr[top];
        top--;
    }

    void peek() {
        if (top < 0) {
            cout<<"Stack is Empty";
            return;
        }
        cout<<"Stack Top is >> "<<arr[top];
    }

    void isEmpty() {
        if (top == -1) {
            cout<<"Stack is Empty !!!";
        } else {
            cout<<"Stack is not Empty !!!";
        }
    }

    void isFull() {
        if (top >= MAX_SIZE - 1) {
            cout<<"Stack is Full ";
        } else {
            cout<<"Stack is not Full !!!";
        }
    }

    void count() {
        cout<<"\nNumber of Element's in Stack is >> "<<top+1<<endl;
    }

    void destroy() {
        top = -1;
        cout<<"Stack Destroyed";
    }

    void display() {
        if (top < 0) {
            cout<<"\nStack is Empty !!";
            return;
        }
        for (int i = 0; i <= top; i++) {
            cout<<" ["<<arr[i];
        }
    }
};

int main() {
    int ch = 0;
    ArrayStack x;
    do {
        cout<<"\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ";
        cin >>ch;
        switch (ch) {
            case 1:
                x.push();
                break;
            case 2:
                x.pop();
                break;
            case 3:
                x.peek();
                break;
            case 4:
                x.isEmpty();
                break;
            case 5:
                x.isFull();
                break;
            case 6:
                x.count();
                break;
            case 7:
                x.destroy();
                break;
            case 8:
                x.display();
                break;
        }
    } while (ch != 9);
    return 0;
}