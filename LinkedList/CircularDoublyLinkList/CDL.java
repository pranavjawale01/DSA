package DSA.LinkedList.CircularDoublyLinkList;
import java.util.Scanner;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CDL {
    public Node head;

    public CDL() {
        head = null;
    }

    public void Insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Insert at Start \n2.Middle \n3.End >> ");
        int ch = sc.nextInt();
        System.out.println("Enter the value >> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        if (ch == 1) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        } else if (ch == 2) {
            Node temp = head;
            System.out.println("After which Node you want to insert data >> ");
            int nextNode = sc.nextInt();

            boolean nodeFound = false;
            do {
                if (temp.data == nextNode) {
                    nodeFound = true;
                    break;
                }
                temp = temp.next;
            } while (temp != head);

            if (nodeFound) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                System.out.println("Node inserted in the middle successfully!");
            } else {
                System.out.println("Node with the specified value not found. Insertion failed.");
            }
        } else if (ch == 3) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }

    public void Search() {
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }
        System.out.println("Enter the value to search: ");
        int value = sc.nextInt();
        Node current = head;
        do {
            if (current.data == value) {
                System.out.println("Node with value " + value + " found.");
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with value " + value + " not found.");
    }

    public void Delete() {
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Enter the value to delete: ");
        int value = sc.nextInt();
        Node current = head;
        do {
            if (current.data == value) {
                if (current == head) {
                    if (head.next == head) {
                        head = null;
                    } else {
                        head.prev.next = head.next;
                        head.next.prev = head.prev;
                        head = head.next;
                    }
                    System.out.println("Node with value " + value + " deleted successfully.");
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    System.out.println("Node with value " + value + " deleted successfully.");
                }
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with value " + value + " not found.");
    }

    public void Display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("- - - <-> ");
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("- - - ");
    }

    public void Count() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int count = 0;
        Node current = head;
        System.out.print("- - - <-> ");
        do {
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("Number of nodes in the list: " + count);
    }

    public void Reverse() {
        if (head == null) {
            System.out.println("List is empty. Cannot reverse.");
            return;
        }

        Node current = head;
        Node temp;
        do {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        } while (current != head);
        head = temp.prev;
        System.out.println("List is reversed successfully.");
    }

    public void Rotate() {
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("List is empty. Cannot rotate.");
            return;
        }
        System.out.println("Enter the number of positions to rotate: ");
        int position = sc.nextInt();
        for (int i = 0; i < position; i++) {
            head = head.next;
        }
        System.out.println("List rotated by " + position + " positions.");
    }

    public static void main(String[] args) {
        CDL x = new CDL();
        int ch = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ");
            ch = sc.nextInt();
            switch (ch) {
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
    }
}