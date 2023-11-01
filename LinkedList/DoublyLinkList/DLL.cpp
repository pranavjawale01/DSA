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

    }

    void Delete()
    {

    }

    void Update()
    {

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

    }

    void Reverse()
    {

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

        } else if (ch == 3) {

        } else if (ch == 4) {

        } else if (ch == 5) {
            x.Display();
        } else if (ch == 6) {

        } else if (ch == 7) {

        }
    }
    return 0;
}