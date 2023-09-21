#include<iostream>
using namespace std;

class Node {
    public:
    int data;
    Node* next;
};

class SLL {
    public:
    int ch1=0;
    Node* head;
    SLL()
    {
        head = nullptr;
    }
    int targetData=0;

    void Insert(int new_data)
    {
        cout<<"\n1.Insert at Front \n2.Insert at End \n3.Insert at Middle\n>>> ";
        cin>>ch1;
        if(ch1==1)
        {
                Node* new_node = new Node();
                new_node->data = new_data;
                new_node->next = head;
                head = new_node;
        }
        else if(ch1==2)
        {
            Node* new_node = new Node();
            new_node->data = new_data;
            new_node->next = nullptr;
            if(head == nullptr)
            {
                head = new_node;
                return;
            }
            Node* current = head;
            while(current->next != nullptr)
            {
                current = current->next;
            }
            current->next = new_node;
        }
        else if(ch1==3)
        {
            cout << "Enter the data of the node after which you want to insert: ";
            cin >> targetData;

            Node* prev_node = head;
            if(prev_node == nullptr)
            {
                cout<<"\nNode with the given data not found.";
                return;
            }
            while (prev_node != nullptr && prev_node->data != targetData) 
            {
                prev_node = prev_node->next;
            }
            if (prev_node == nullptr) 
            {
                cout << "Node with the given data not found." << endl;
            }
            else
            {
                Node* new_node = new Node();
                new_node->data = new_data;
                new_node->next = prev_node->next;
                prev_node->next = new_node;
            }
        }
    }
    void Search(int element)
    {
        int count=0;
        Node* current = head;
        while(current != NULL)
        {
            if(current->data == element)
            {
                cout<<"Element "<<current->data<<" is found at index "<<count;
                return;
            }
            current = current->next;
            count++;
        }
        cout<<"Element Not Present in Linked List";
        return;
    }
    void Delete()
    {

    }
    void Display()
    {
        Node* current = head;
        while(current != nullptr)
        {
            cout<<current->data<<" -> ";
            current = current->next;
        }
        cout<<"NULL"<<endl;
    }
    void Count()
    {
        int count = 0;
        Node* current = head;
        while(current != nullptr)
        {
            current = current->next;
            count +=1;
        }
        cout<<"The Number of Node's in Link List is >> "<<count;
    }
    void Reverse()
    {

    }
};

int main()
{
    SLL x;
    int ch=0, data;
    do
    {
        cout<<"\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Exit\n>>> ";
        cin>>ch;
        switch(ch)
        {
            case 1:
                cout<<"\nEnter Value to Insert >>> ";
                cin>>data;
                x.Insert(data);
                break;
            case 2:
                cout<<"\nEnter Element to Search >>> ";
                cin>>data;
                x.Search(data);
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
        }
    }while(ch!=7);

    return 0;
}