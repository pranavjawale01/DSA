package DSA.LinkedList.DoublyLinkList;

import java.util.Scanner;

class DLL
{
    static class Node
    {
        int data;
        Node next,prev;
        Node(int d)
        {
            data = d;
            next = null;
            prev = null;
        }
    }
    static Node head;
    int ch1 = 0, targetData = 0;
    static Scanner sc = new Scanner(System.in);

    static void Insert()
    {
        System.out.println("\nEnter Data >> ");
        int newData = sc.nextInt();
        Node newNode = new Node(newData);

        System.out.println("\n1.Insert at Start \n2.Middle \n3.End >> ");
        int ch1 = sc.nextInt();

        if (ch1 == 1) {
            newNode.next = head;
            newNode.prev = null;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else if (ch1 == 2) {
            System.out.println("After which node you want to insert data >> ");
            ch1 = sc.nextInt();
            Node temp = head;
            while (temp != null && temp.data != ch1) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("\nNode not present");
                return;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
        } else if (ch1 == 3) {
            newNode.next = null;
            if (head == null) {
                newNode.prev = null;
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
        }
    }

    static void Delete()
    {
        System.out.println("\nEnter the data to delete >> ");
        int targetData = sc.nextInt();
        Node temp = head;
        while (temp != null && temp.data != targetData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("\nData not found in DLL");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        System.out.println("\nData Deleted from the DLL");
    }

    static void Search()
    {
        System.out.println("\nEnter the data to search >> ");
        int targetData = sc.nextInt();
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == targetData) {
                System.out.println("\nData found in the DLL at index " + count);
                return;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Data not found in the DLL");
    }

    static void Update()
    {
        System.out.println("\nEnter the data to update >> ");
        int targetData = sc.nextInt();
        Node temp = head;
        while (temp != null && temp.data != targetData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data not found in the DLL");
            return;
        }
        System.out.println("Enter the new Data value >> ");
        temp.data = sc.nextInt();
        System.out.println("Data updated in the DLL");
    }

    static void Display()
    {
        if (head == null) {
            System.out.println("\n\nThe DLL is empty");
            return;
        }
        Node temp = head;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    static void Count()
    {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("\nNumber of nodes in DLL " + count);
    }

    static void Reverse()
    {
        System.out.println("\n\nDLL Before Reversed \n");
        Display();
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
        System.out.println("\n\nDLL After Reversed \n");
        Display();
    }

    public static void main(String[] args)
    {
        DLL x = new DLL();
        int ch = 0;
        while (ch != 8) {
            System.out.print("\n1.Insert\n2.Search\n3.Delete\n4.Update\n5.Display\n6.Count\n7.Reverse\n8.Exit\n> > > ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Insert();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    Delete();
                    break;
                case 4:
                    Update();
                    break;
                case 5:
                    Display();
                    break;
                case 6:
                    Count();
                    break;
                case 7:
                    Reverse();
                    break;
                case 8:
                    break;
            }
        }
    }
}