#include<iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node(int value) {
        data = value;
        next = nullptr;
    }
};

class LinkedList {
private:
    Node* head;
public:
    LinkedList() {
        head = nullptr;
    }

    void Push(int value) {
        Node* newNode = new Node(value);
        newNode->next = head;
        head = newNode;
    }

    int Pop() {
        if (head == nullptr) {
            cout<<"Stack is Empty";
            return -1;
        }
        int poppedValue = head->data;
        Node* temp = head;
        head = head->next;
        delete temp;
        return poppedValue;
    }

    int Peek() {
        if (head == nullptr) {
            cout<<"Stack is Empty";
            return -1;
        }
        cout<<"Top Element is >> "<<head->data;
        return head->data;
    }

    int Count() {
        int count = 0;
        Node* current = head;
        while (current != nullptr) {
            count++;
            current = current->next;
        }
        cout<<"Number of Stack Element is >> "<<count;
        return count;
    }

    void Destroy() {
        while (head != nullptr) {
            Pop();
        }
        cout<<"Stack Destroyed";
    }

    void Display() {
        if (isEmpty()) {
            return;
        }
        Node* current = head;
        while (current != nullptr) {
            cout<<current->data<<"] ";
            current = current->next;
        }
        cout<<endl;
    }

    bool isEmpty() {
        if (head == nullptr) {
            cout<<"Stack is Empty";
        } else {
            cout<<"Stack is not Empty";
        }
        return head == nullptr;
    }
};

int main() {
    int ch = 0 , data = 0;
    LinkedList x;
    do {
        cout<<"\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ";
        cin>>ch;
        switch(ch) {
            case 1:
                cout<<"Enter data >> ";
                cin>>data;
                x.Push(data);
                break;
            case 2:
                x.Pop();
                break;
            case 3:
                x.Peek();
                break;
            case 4:
                x.isEmpty();
                break;
            case 6:
                x.Count();
                break;
            case 7:
                x.Destroy();
                break;
            case 8:
                x.Display();
                break;
        }
    } while (ch != 9);
    return 0;
}