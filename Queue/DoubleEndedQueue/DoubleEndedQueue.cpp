// Using Linked List

#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;
    Node(int value) : data(value), next(nullptr), prev(nullptr) {}
};

class Deque {
private:
    Node* front;
    Node* rear;
public:
    Deque() : front(nullptr), rear(nullptr) {}

    bool isEmpty() const {
        return front == nullptr;
    }

    void addToFront(int element) {
        Node* newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode->next = front;
            front->prev = newNode;
            front = newNode;
        }
    }

    void addToRear(int element) {
        Node* newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode->prev = rear;
            rear->next = newNode;
            rear = newNode;
        }
    }

    int removeFromFront() {
        if (isEmpty()) {
            cout<<"Deque is Empty";
            throw runtime_error(".");
        }
        int rearValue = front->data;
        Node* temp = front;
        if (front == rear) {
            front = rear = nullptr;
        } else {
            front = front->next;
            front->prev = nullptr;
        }
        delete temp;
        return rearValue;
    }

    int removeFromRear() {
        if (isEmpty()) {
            cout<<"Deque is Empty";
            throw runtime_error(".");
        }
        int rearValue = rear->data;
        Node* temp = rear;
        if (front == rear) {
            front = rear = nullptr;
        } else {
            rear = rear->prev;
            rear->next = nullptr;
        }
        delete temp;
        return rearValue;
    }

    int size() const {
        int count = 0;
        Node* current = front;
        while (current != nullptr) {
            current = current->next;
            count++;
        }
        return count;
    }

    void printDeque() const {
        Node* current = front;
        cout<<"NULL";
        while (current != nullptr) {
            cout<<" <-> "<<current->data;
            current = current->next;
        }
        cout<<" <-> "<<"NULL";
    }

    ~Deque() {
        while (front != nullptr) {
            Node* temp = front;
            front = front->next;
            delete temp;
        }
    }
};

int main() {
    int ch = 0, data = 0;
    Deque deque;

    do {
        cout << "\n1. Insert at Front\n2. Insert at End\n3. Delete from Front\n4. Delete from End\n5. Print\n6. Size\n7. Exit\nEnter your choice: ";
        cin >> ch;

        switch (ch) {
            case 1:
                cout << "Enter data: ";
                cin >> data;
                deque.addToFront(data);
                break;
            case 2:
                cout << "Enter data: ";
                cin >> data;
                deque.addToRear(data);
                break;
            case 3:
                try {
                    cout << "Removed from front: " << deque.removeFromFront() << endl;
                } catch (const exception& e) {
                    cerr << e.what() << endl;
                }
                break;
            case 4:
                try {
                    cout << "Removed from end: " << deque.removeFromRear() << endl;
                } catch (const exception& e) {
                    cerr << e.what() << endl;
                }
                break;
            case 5:
                cout << "Deque elements: ";
                deque.printDeque();
                cout << endl;
                break;
            case 6:
                cout << "Deque size: " << deque.size() << endl;
                break;
            case 7:
                cout << "Exiting the program.\n";
                break;
            default:
                cout << "Invalid choice. Please enter a valid option.\n";
        }
    } while (ch != 7);

    return 0;
}