#include<iostream>
#include<algorithm>

using namespace std;

class PriorityQueue {
private:
    int capacity = 100;
    int *arr;
    int size;

    void resize() {
        capacity *= 2;
        int *newArr = new int[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            newArr[i] = arr[i];
        }
        delete[] arr;
        arr = newArr;
    }

    void swap(int& a, int& b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (arr[index] < arr[parent]) {
                swap(arr[index], arr[parent]);
                index = parent;
            } else {
                break;
            }
        }
    }

    void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;
        if (leftChild < size && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < size && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(arr[index], arr[smallest]);
            heapifyDown(smallest);
        }
    }

public:
    PriorityQueue() : size(0), arr(new int[capacity]) {}

    ~PriorityQueue() {
        delete[] arr;
    }

    bool isEmpty() {
        return size == 0;
    }

    void push(int value) {
        if (size >= capacity) {
            resize();
        }
        arr[size] = value;
        heapifyUp(size);
        size++;
    }

    int pop() {
        if (isEmpty()) {
            cout<<"Priority Queue is Empty";
            return - 1;
        }
        int top = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
        return top;
    }

    void print() {
        if (isEmpty()) {
            cout<<"\nPriority Queue is Empty"<<endl;
            return;
        }
        cout<<"\nPriority Queue : ";
        for (int i = 0; i < size; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<endl;
    }

    void printOrdered() {
        if (isEmpty()) {
            cout<<"Priority Queue is Empty"<<endl;
            return;
        }
        int sortedArr[capacity];
        copy(arr, arr+size, sortedArr);
        sort(sortedArr, sortedArr + size);
        cout<<"Priority Queue in Priority Order : ";
        for (int i = 0; i < size; i++) {
            cout<<sortedArr[i]<<" ";
        }
        cout<<endl;
    }
};

int main() {
    PriorityQueue x;
    int ch = 0, data = 0;
    do {
        cout<<"\n1. Push\n2. Pop\n3. Print \n4. Print Ordered\n5. Exit\n > > ";
        cin >> ch;
        switch (ch)
        {
            case 1:
                cout<<"Enter Data >> ";
                cin>>data;
                x.push(data);
                break;
            
            case 2:
                data = x.pop();
                cout<<"\nPopped Element is >> "<<data<<endl;
                break;
            
            case 3:
                x.print();
                break;
            
            case 4:
                x.printOrdered();
                break;

            default:
                cout<<"Enter Valid Choise";
                break;
        }
    } while (ch != 5);
    return 0;
}