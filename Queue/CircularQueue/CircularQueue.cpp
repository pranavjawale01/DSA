#include <iostream>
#include <vector>
using namespace std;

class CircularQueue {
private:
    int rear;
    int front;
    vector<int> arr;

public:
    CircularQueue(int size) {
        rear = -1;
        front = -1;
        arr.resize(size);
    }

    void enqueue(int data) {
        if (isFull()) {
            cout << "Queue is Full" << endl;
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % arr.size();
            arr[rear] = data;
            cout << "Data Added" << endl;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
        } else {
            front = (front + 1) % arr.size();
        }
    }

    void display() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
        } else {
            cout << "<-";
            for (int i = front; i != (rear + 1) % arr.size(); i = (i + 1) % arr.size()) {
                cout << " [" << arr[i] << "] ";
            }
            cout << "->" << endl;
        }
    }

    bool isFull() {
        return (rear + 1) % arr.size() == front;
    }

    bool isEmpty() {
        return rear == front && rear == -1;
    }

    int size() {
        if (isEmpty()) {
            return 0;
        } else if (front <= rear) {
            return rear - front + 1;
        } else {
            return arr.size() - front + rear + 1;
        }
    }

    void clear() {
        rear = -1;
        front = -1;
        cout << "Queue cleared" << endl;
    }
};

int main() {
    CircularQueue x(100);

    while (true) {
        cout << "\n1.Enqueue \n2.Dequeue \n3.Display \n4.Size \n5.Clear \n6.Exit" << endl;
        int ch;
        cin >> ch;

        if (ch == 1) {
            cout << "Enter the data >> ";
            int data;
            cin >> data;
            x.enqueue(data);
        } else if (ch == 2) {
            x.dequeue();
        } else if (ch == 3) {
            x.display();
        } else if (ch == 4) {
            cout << "Size: " << x.size() << endl;
        } else if (ch == 5) {
            x.clear();
        } else if (ch == 6) {
            break;
        }
    }

    return 0;
}