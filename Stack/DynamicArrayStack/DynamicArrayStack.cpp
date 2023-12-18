#include <iostream>
#include <stdexcept>

using namespace std;

template <typename T> class DynamicArrayStack {
private:
    T* array;
    int capacity;
    int size;

    void resize(int newCapacity) {
        T* newArray = new T[newCapacity];
        for (int i = 0; i < size; ++i) {
            newArray[i] = array[i];
        }
        delete[] array;
        array = newArray;
        capacity = newCapacity;
    }

public:
    DynamicArrayStack(int initialCapacity = 10) {
        capacity = initialCapacity;
        array = new T[capacity];
        size = 0;
    }
    ~DynamicArrayStack() {
        delete[] array;
    }

    bool isEmpty() const {
        if (size == 0) {
            cout<<"\nStack is Empty"<<endl;
        } else {
            cout<<"\nStack is not Empty"<<endl;
        }
        return size == 0;
    }

    bool isFull() const {
        if ( size == capacity) {
            cout<<"Stack is Full. But you can increment size";
        } else {
            cout<<"Stack is not full";
        }
        return size == capacity;
    }

    int getSize() const {
        cout<<"The size of stack is >> "<<size<<endl;
        return size;
    }

    void push(const T& value) {
        if (size == capacity) {
            resize(capacity *2);
        }
        array[size++] = value;
    }

    T pop() {
        if (isEmpty()) {
            throw out_of_range("Stack is Empty");
        }
        T poppedElement = array[--size];
        if (size > 0 && size < capacity / 2) {
            resize(capacity / 2);
        }
        cout<<"Element "<<poppedElement<<" is popped";
        return poppedElement;
    }

    T peek() const {
        if (isEmpty()) {
            throw out_of_range("Stack is Empty");
        } 
        cout<<"Peek element of stack is "<<array[size-1];
        return array[size - 1];
    }

    void display() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i++) {
            cout<<" ["<<array[i];
        }
        cout<<endl;
    }

    void count() {
        cout<<"Number of elements in stack is "<<size;
    }

    void destroy() {
        delete[] array;
        capacity = 10;
        array = new T[capacity];
        size = 0;
        cout<<"Stack is Destroyed";
    }
};

int main() {
    DynamicArrayStack<int> x;
    int ch = 0;
    int value;
    do {
        cout<<"\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ";
        cin >>ch;
        switch (ch) {
            case 1:
                cout<<"Enter Value to push >> ";
                cin>>value;
                x.push(value);
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