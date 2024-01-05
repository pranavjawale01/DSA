#include<iostream>
#include<algorithm>

using namespace std;

template <typename T>
class DEPQ {
private:
    struct Node {
        T value;
        int priority;
    };

    static const size_t INITIAL_CAPACITY = 10;
    Node* data;
    size_t front;
    size_t back;
    size_t capacity;

    void resize() {
        size_t newCapacity = capacity * 2;
        Node* newData = new Node[newCapacity];
        copy(data, data + front, newData);
        copy(data + capacity - back, data + capacity, newData + newCapacity - back);

        delete[] data;
        data = newData;
        capacity = newCapacity;
    }

public:
    DEPQ() :
        data(new Node[INITIAL_CAPACITY]),
        front(0),
        back(0),
        capacity(INITIAL_CAPACITY) {}

    ~DEPQ() {
        delete[] data;
    }

    void print() const {
        cout << "\nFront Heap : ";
        for (size_t i = 0; i < front; i++) {
            cout << " (" << data[i].value << ", " << data[i].priority << ") ";
        }
        cout << "\nBack Heap : ";
        for (size_t i = capacity - back; i < capacity; i++) {
            cout << " (" << data[i].value << ", " << data[i].priority << ") ";
        }
        cout << endl;
    }

    void pushFront(const T& value, int priority) {
        if (front == capacity / 2) {
            resize();
        }
        data[front++] = {value, priority};
        push_heap(data, data + front, [](const Node& a, const Node& b) {
            return a.priority > b.priority;
        });
        print();
    }

    void pushBack(const T& value, int priority) {
        if (back == capacity / 2) {
            resize();
        }
        data[capacity - ++back] = {value, priority};
        push_heap(data, data + front, [](const Node& a, const Node& b) {
            return a.priority < b.priority;
        });
        print();
    }


    T popFront() {
        if (front == 0) {
            return T();
        }
        pop_heap(data, data + front, [](const Node& a, const Node& b) {
            return a.priority > b.priority;
        });

        T value = data[--front].value;
        print();
        return value;
    }

    T popBack() {
        if (back == 0) {
            return T();
        }
        pop_heap(data + capacity - back, data + capacity, [](const Node& a, const Node& b) {
            return a.priority < b.priority;
        });

        T value = data[capacity - back--].value;
        print();
        return value;
    }
};

int main() {
    DEPQ<int> depq;

    int ch = 0, data = 0, priority = 0;
    do {
        cout << "\n1. Push Front\n2. Push Back\n3. Pop Front\n4. Pop Back\n5. Print\n6. Exit\n";
        cout << "Enter your choice: ";
        cin >> ch;

        switch (ch) {
            case 1:
                cout << "Enter data and priority: ";
                cin >> data >> priority;
                depq.pushFront(data, priority);
                break;

            case 2:
                cout << "Enter data and priority: ";
                cin >> data >> priority;
                depq.pushBack(data, priority);
                break;

            case 3:
                cout << "Popped from front: " << depq.popFront() << endl;
                break;

            case 4:
                cout << "Popped from back: " << depq.popBack() << endl;
                break;

            case 5:
                depq.print();
                break;

            case 6:
                cout << "Exiting..." << endl;
                break;

            default:
                cout << "Invalid choice. Please try again." << endl;
                break;
        }
    } while (ch != 6);

    return 0;
}