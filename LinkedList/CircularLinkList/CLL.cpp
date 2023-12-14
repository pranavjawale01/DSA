#include <iostream>
using namespace std;

class Node {
    public:
    int data;
    Node* next;
};

class CLL {
    public:
    Node* head;
    CLL() {
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
            return;
        }

        if (ch == 1) {
            newNode->next = head;
            Node* temp = head;
            while (temp->next != head) {
                temp = temp->next;
            }
            temp->next = newNode;
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
                temp->next = newNode;
                cout << "Node inserted in the middle successfully!" << endl;
            } else {
                cout << "Node with the specified value not found. Insertion failed." << endl;
            }
        } else if (ch == 3) {
            Node* temp = head;
            while (temp->next != head) {
                temp = temp->next;
            }
            temp->next = newNode;
            newNode->next = head;
        }
    }

    void Search() {
        int nodeData = 0, index = 0;
        cout<<"Enter Node to search >> ";
        cin>>nodeData;
        bool found = false;
        Node* temp = head;
        do 
        {
            if (temp->data == nodeData) {
                found = true;
                break;
            }
            temp = temp->next;
            index++;
        } while (temp != head);

        if (found) {
            cout<<"Node is present at index "<<index<<endl;
        } else {
            cout<<"Node not present in CLL";
        }
    }

    void Delete() {
        if (!head) {
            cout << "CLL is Empty" << endl;
            return;
        }

        int value;
        cout << "Enter Node value to delete >> ";
        cin >> value;

        Node* temp = head;
        Node* prev = nullptr;

        do {
            if (temp->data == value) {
                if (temp == head) {
                    if (temp->next == head) {
                        delete temp;
                        head = nullptr;
                    } else {
                        head = temp->next;
                        Node* lastNode = head;
                        while (lastNode->next != temp) {
                            lastNode = lastNode->next;
                        }
                        lastNode->next = head;
                        delete temp;
                    }
                } else {
                    prev->next = temp->next;
                    delete temp;
                }

                cout << "Node deleted successfully" << endl;
                return;
            }

            prev = temp;
            temp = temp->next;
        } while (temp != head);

        cout << "Node with the specified value not found. Deletion failed." << endl;
    }

    void Display() {
        if (!head) {
            cout<<"List is empty"<<endl;
            return;
        }
        Node* temp = head;
        cout<<"HEAD -> ";
        do 
        {
            cout<<temp->data<<" -> ";
            temp = temp->next;
        } while (temp != head);
        cout<<" HEAD"<<endl;
    }

    void Count() {
        if (!head) {
            cout << "Total 0 nodes are present" << endl;
            return;
        }
        Node* temp = head;
        int count = 0;
        do 
        {
            temp = temp->next;
            count++; 
        } while (temp != head);
        cout<<"Total "<<count<<" nodes are present";
    }
 
    void Reverse() {
        if (!head || !(head->next)) {
            cout << "List is empty or has only one node. No reversal needed." << endl;
            return;
        }

        cout << "List Before reversed successfully" << endl;
        Display();
        cout << endl;

        Node* prev = nullptr;
        Node* current = head;
        Node* next = nullptr;

        do {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head = prev;

        cout << "List reversed successfully" << endl;
        Display();
    }

    void Rotate() {
        if (!head || !(head->next)) {
            cout<<"\nRotation not possible";
            return ;
        }
        int k;
        cout<<"Enter the number of positions to rotate >> ";
        cin>>k;
        if (k == 0) {
            cout<<"No rotation performed "<<endl;
            return;
        }
        Node* temp = head;
        int count = 1;
        while (temp->next != head) {
            temp = temp->next;
            count++;
        }
        temp->next = head;
        for (int i = 0; i < k % count; i++) {
            temp = temp->next;
        }
        head = temp->next;
        temp->next = head;
        cout<<"Liste rotated successfully";
    }
};

int main()
{
    CLL x;
    int ch=0;
    do
    {
        cout<<"\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ";
        cin>>ch;
        switch(ch)
        {
            case 1:
                x.Insert();
                break;
            case 2:
                x.Search();
                break;
            case 3:
                x.Delete();
                break;
            case 4:
                x.Display();
                break;
            case 5:
                x.Count();
                break;
            case 6:
                x.Reverse();
                break;
            case 7:
                x.Rotate();
                break;
        }
    } while (ch != 8);

    return 0;
}