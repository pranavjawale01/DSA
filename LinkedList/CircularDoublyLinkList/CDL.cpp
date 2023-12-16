#include<iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;
};

class CDL {
public:
    Node* head;
    CDL() {
        head = nullptr;
    }

    void Insert() {
        cout << "\n1.Insert at Start \n2.Middle \n3.End >> ";
        int ch = 0, data = 0;
        cin >> ch;
        cout << "Enter the value >> ";
        cin >> data;
        Node* newNode = new Node();
        newNode->data = data;

        if (!head) {
            head = newNode;
            head->next = head;
            head->prev = head;
            return;
        }

        if (ch == 1) {
            newNode->next = head;
            newNode->prev = head->prev;
            head->prev->next = newNode;
            head->prev = newNode;
            head = newNode;
        } else if (ch == 2) {
            Node* temp = head;
            cout << "After which Node you want to insert data >> ";
            int nextNode = 0;
            cin >> nextNode;

            bool nodeFound = false;
            do {
                if (temp->data == nextNode) {
                    nodeFound = true;
                    break;
                }
                temp = temp->next;
            } while (temp != head);

            if (nodeFound) {
                newNode->next = temp->next;
                newNode->prev = temp;
                temp->next->prev = newNode;
                temp->next = newNode;
                cout << "Node inserted in the middle successfully!" << endl;
            } else {
                cout << "Node with the specified value not found. Insertion failed." << endl;
            }
        } else if (ch == 3) {
            newNode->next = head;
            newNode->prev = head->prev;
            head->prev->next = newNode;
            head->prev = newNode;
        }
    }

    void Search(int value) {
        if (head == nullptr) {
            cout<<"\nList is empty"<<endl;
            return;
        }
        Node* current = head;
        do {
            if (current->data == value) {
                cout<<"Node with value "<<value <<" found."<<endl;
                return;
            }
            current = current->next;
        } while (current != head);
        cout<<"Node with value "<<value<<" not found "<<endl;
    }

    void Delete(int value) {
        if (head == nullptr) {
            cout<<"List is empty."<<endl;
            return;
        }
        Node* current = head;
        do {
            if (current->data == value) {
                if (current == head) {
                    if (head->next == head) {
                        delete head;
                        head = nullptr;
                    } else {
                        head->prev->next = head->next;
                        head->next->prev = head->prev;
                        head = head->next;
                        delete current;
                    }
                } else {
                    current->prev->next = current->next;
                    current->next->prev = current->prev;
                    delete current;
                }
                cout << "Node with value " << value << " deleted successfully." << endl;
                return;
            }
            current = current->next;
        } while (current != head);
        cout << "Node with value " << value << " not found " << endl;
    }

    void Display() {
        if (head == nullptr) {
            cout<<"list is empty"<<endl;
            return;
        }
        Node* current = head;
        cout<<"- - - <-> ";
        do {
            cout<<current->data<<" <-> ";
            current = current->next;
        } while (current != head);
        cout<<"- - - "<<endl;
    }

    void Count() {
        if (head == nullptr) {
            cout<<"list is empty"<<endl;
            return;
        }
        int count = 0;
        Node* current = head;
        do {
            count++;
            current = current->next;
        } while (current != head);
        cout << "Number of nodes in the list: " << count << endl;
    }

    void Reverse() {
        if (head == nullptr) {
            cout << "List is empty. Cannot reverse." << endl;
            return;
        }

        Node* current = head;
        Node* temp = nullptr;
        do {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        } while (current != head);
        head = temp->prev;
        cout<<"List is reversed successfully"<<endl;
    }

    void Rotate(int position) {
        if (head == nullptr) {
            cout << "List is empty. Cannot rotate." << endl;
            return;
        }
        for (int i = 0; i < position; i++) {
            head = head->next;
        }
        cout << "List rotated by " << position << " positions." << endl;
    }
};

int main() {

    CDL x;
    int ch = 0, value = 0;
    do {
        cout<<"\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ";
        cin>>ch;
        if (ch == 1) {
            x.Insert();
        } else if (ch == 2) {
            cout << "Enter the value to search: ";
            cin >> value;
            x.Search(value);
        } else if (ch == 3) {
            cout << "Enter the value to delete: ";
            cin >> value;
            x.Delete(value);
        } else if (ch == 4) {
            x.Display();
        } else if (ch == 5) {
            x.Count();
        } else if (ch == 6) {
            x.Reverse();
        } else if (ch == 7) {
            cout << "Enter the number of positions to rotate: ";
            cin >> value;
            x.Rotate(value);
        }
    } while (ch != 8);

    return 0;
}