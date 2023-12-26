#include <iostream>

using namespace std;

class LinearQueue {
private:
    static const int MAX_SIZE = 100;
    int arr[MAX_SIZE];
    int front , rear;
public:
    LinearQueue() {
        front = -1;
        rear = -1;
    }

    bool isEmpty() {
        return front == -1 && rear == -1;
    }

    bool isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    void enqueue(int element) {
        if (isFull()) {
            cout<<"\nQueue is Full";
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }
        arr[rear] = element;
        cout<<"Enqueued : "<<element<<endl;
    }

    void dequeue() {
        if (isEmpty()) {
            cout<<"Queue is Empty."<<endl;
            return;
        }
        cout<<"Dqueued : "<<arr[front]<<endl;
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
    }

    void display() {
        if (isEmpty()) {
            cout<<"\nQueue is Empty"<<endl;
            return;
        }
        int i = front;
        while (i != rear) {
            cout<<" ["<<arr[i]<<"] ";
            i = (i+1) % MAX_SIZE;
        }
        cout<<" ["<<arr[rear]<<"] "<<endl;
    }
};

void menu() {
    cout << "1. Enqueue\n";
    cout << "2. Dequeue\n";
    cout << "3. Display\n";
    cout << "4. Exit\n";
    cout << "Enter your choice: ";
}

int main() {
    LinearQueue x;
    int ch = 0;
    while (true) {
        menu();
        cin>>ch;
        switch (ch) {
            case 1:
                int element;
                cout << "Enter element to enqueue: ";
                cin >> element;
                x.enqueue(element);
                break;
            case 2:
                x.dequeue();
                break;
            case 3:
                x.display();
                break;
            case 4:
                cout << "Exiting program.\n";
                return 0;
        }
    }
    return 0;
}