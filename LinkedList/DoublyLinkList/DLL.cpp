#include<iostream>
using namespace std;

class Node
{
    public:
    int data;
    Node* next;
    Node* prev;
};

class DLL
{
    public:

    int ch1=0, targetData=0;
    Node* head;
    DLL()
    {
        head=nullptr;
    }

    void Insert() {
        int new_data;
        cout<<"\nEnter Data >> ";
        cin>>new_data;
        cout<<"\n1.Insert at start\n2.Middle\n3.End \n>> ";
        cin>>ch1;
        Node* new_node = new Node();
        new_node->data = new_data;

        if (ch1 == 1) {
            new_node->next = head;
            new_node->prev = nullptr;
            if (head != nullptr) {
                head->prev = new_node;
            }
            head = new_node;
        } else if (ch1 == 2) {
            cout<<"\nAfter which Node you want to insert data >> ";
            cin>>ch1;
            Node* temp = head;
            while (temp != nullptr && temp->data != ch1) {
                temp = temp->next;
            }
            if (temp == nullptr) {
                cout<<"\nNode not present";
                return;
            }
            new_node->next = temp->next;
            new_node->prev = temp;
            if (temp->next != nullptr) {
                temp->next->prev = new_node;
            }
            temp->next = new_node;
        } else if (ch1 == 3) {
            new_node->next = nullptr;
            if (head == nullptr) {
                new_node->prev = nullptr;
                head = new_node;
            } else {
                Node* temp = head;
                while (temp->next != nullptr) {
                    temp = temp->next;
                }
                temp->next = new_node;
                new_node->prev = temp;
            }
        }
    }

    void Search()
    {
        int i = 0;
        if (head == nullptr) {
            cout<<"\nThe DLL is empty";
            return;
        }
        cout<<"\nEnter the data to search : "<<endl;
        cin>>targetData;
        Node* temp = head;
        while (temp != nullptr) {
            if (temp->data == targetData){
                cout<<"\nData found in the DLL. At index "<<i;
            }
            i++;
            temp = temp->next;
        }
        cout << "\nData not found in the DLL.";
    }

    void Delete()
    {
        if (head == nullptr) {
            cout<<"\nThe DLL is empty. Can't perform delete"<<endl;
            return;
        }
        cout<<"\nEnter the data to delete : ";
        cin >> targetData;
        Node* temp = head;
        while (temp != nullptr && temp->data != targetData) {
            temp = temp->next;
        }
        if (temp == nullptr) {
            cout<<"\nData not ffound in DLL"<<endl;
            return;
        }
        if (temp->prev != nullptr) {
            temp->prev->next = temp->next;
        } else {
            head = temp->next;
        }
        if (temp->next != nullptr) {
            temp->next->prev = temp->prev;
        }
        delete temp;
        cout<<"\nData deleted from the DLL";
    }

    void Update()
    {
        if (head == nullptr) {
            cout<<"\nThe DLL is empty.";
            return;
        }
        cout<<"\nEnter the data to update : ";
        cin>>targetData;
        Node* temp = head;
        while (temp != nullptr && temp->data != targetData) {
            temp = temp->next;
        }
        if (temp == nullptr) {
            cout<<"\nData not found in the DLL.";
        }
        cout<<"\nEnter the new data value : ";
        cin>>temp->data;
        cout<<"\nData Update in the DLL";
    }

    void Display()
    {
        if (head == nullptr) {
            cout<<"\nThe DLL is empty";
            return;
        }
        Node* temp = head;
        cout<<"NULL <-> ";
        while(temp != nullptr) {
            cout<<temp->data<<" <-> ";
            temp = temp->next;
        }
        cout<<"NULL";
    }

    void Count()
    {
        int count = 0;
        Node* temp = head;
        while (temp != nullptr) {
            count++;
            temp = temp->next;
        }
        cout<<"\nNumber of nodes in the DLL : "<<count<<endl;
    }

    void Reverse()
    {
        cout<<"DLL Before Reveresed >> "<<endl;
        Display();
        cout<<endl<<endl;
        Node* current = head;
        Node* temp = nullptr;
        while (current != nullptr) {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        }
        if (temp != nullptr) {
            head = temp->prev;
        }
        cout<<"DLL After Reveresed >> "<<endl;
        Display();
    }
};

int main()
{
    DLL x;
    int ch = 0;
    while (ch != 8) {
        cout<<"\n1.Insert\n2.Search\n3.Delete\n4.Update\n5.Display\n6.Count\n7.Reverse\n8.Exit\n> > > ";
        cin>>ch;
        if (ch == 1) {
            x.Insert();
        } else if (ch == 2) {
            x.Search();
        } else if (ch == 3) {
            x.Delete();
        } else if (ch == 4) {
            x.Update();
        } else if (ch == 5) {
            x.Display();
        } else if (ch == 6) {
            x.Count();
        } else if (ch == 7) {
            x.Reverse();
        }
    }
    return 0;
}