package DSA.LinkedList.SinglyLinkList;

import java.util.Scanner;

class SLL
{
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static Node head;
    static int ch1=0,targetData;
    static Scanner sc = new Scanner(System.in);

    static void Insert(int new_data)
    {
        System.out.println("\n1.Insert at Front \n2.Insert at End \n3.Insert at Middle\n>>> ");
        ch1=sc.nextInt();
        if(ch1==1)
        {
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
        }
        else if(ch1==2)
        {
            Node new_node = new Node(new_data);
            if(head==null)
            {
                head = new Node(new_data);
                return;
            }
            new_node.next = null;
            Node last = head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
            return;
        }
        else if(ch1==3)
        {
            System.out.println("Enter the data of the node after which you want to insert: ");
            targetData=sc.nextInt();
            Node prev_node = head;
            while (prev_node != null && prev_node.data != targetData) {
                prev_node = prev_node.next;
            }
            if(prev_node == null)
            {
                System.out.println("The given previous node cannot be null");
                return;
            }
            Node new_node = new Node(new_data);
            new_node.next = prev_node.next;
            prev_node.next = new_node;

        }
    }
    static void Search(int element)
    {
        Node current = head; 
        int count=0;
        while(current != null)
        {
            if(current.data == element)
            {
                System.out.println("Element "+current.data+" is found at index "+count);
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Element Not present in LinkedList");
        return;
    }
    static void Delete()
    {
        System.out.println("1.Delete Node By Index \n2.Delete Node by Value \n>> ");
        ch1 = sc.nextInt();
        if(ch1==1)
        {
            System.out.println("Enter the Index >> ");
            targetData = sc.nextInt();
            if(head==null)
            {
                return;
            }
            Node temp = head;
            if(targetData==0)
            {
                head = temp.next;
                return;
            }
            for(int i=0;temp!=null && i < targetData-1;i++)
            {
                temp = temp.next;
            }
            if(temp == null || temp.next == null)
            {
                return;
            }
            Node next = temp.next.next;
            temp.next = next;
        }
        else if(ch1==2)
        {
            System.out.println("Enter the Value >> ");
            targetData = sc.nextInt();
            if(head == null)
            {
                return;
            }
            if(head.data == targetData)
            {
                head = head.next;
                return;
            }
            Node current = head;
            while(current.next != null && current.next.data != targetData)
            {
                current = current.next;
            }
            if(current.next == null)
            {
                return;
            }
            current.next = current.next.next;
        }
    }
    static void Display()
    {
        Node node = head;
        while(node != null)
        {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
    static void Count()
    {
        int count  = 0;
        Node node = head;
        while(node != null)
        {
            node = node.next;
            count += 1;
        }
        System.out.println("The Number of Node's in Linked List is >> "+count);
    }
    static void Reverse()
    {
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public static void main(String[] args)
    {
        SLL x = new SLL();
        Scanner sc = new Scanner(System.in);
        int ch=0,data;
        do
        {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Exit");
            System.out.println(">>> ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Enter Data to Insert >> ");
                    data=sc.nextInt();
                    x.Insert(data);
                    break;
                case 2:
                    System.out.println("Enter Element to search");
                    data=sc.nextInt();
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

        }while(ch != 7);
    }
}