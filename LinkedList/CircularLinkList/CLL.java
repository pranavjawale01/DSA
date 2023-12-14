package DSA.LinkedList.CircularLinkList;

import java.util.Scanner;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CLLx {
    public Node head;

    public CLLx() {
        head = null;
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1.Insert at Start \n2.Middle \n3.End >> ");
        int ch = scanner.nextInt();
        System.out.println("Enter the value >> ");
        int data = scanner.nextInt();
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        if (ch == 1) {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        } else if (ch == 2) {
            Node temp = head;
            System.out.println("After which Node you want to insert data >> ");
            int nextNode = scanner.nextInt();
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
                temp.next = newNode;
                System.out.println("Node inserted in the middle successfully!");
            } else {
                System.out.println("Node with the specified value not found. Insertion failed.");
            }
        } else if (ch == 3) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Node to search >> ");
        int nodeData = scanner.nextInt();
        boolean found = false;
        Node temp = head;
        int index = 0;

        do {
            if (temp.data == nodeData) {
                found = true;
                break;
            }
            temp = temp.next;
            index++;
        } while (temp != head);

        if (found) {
            System.out.println("Node is present at index " + index);
        } else {
            System.out.println("Node not present in CLL");
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        if (head == null) {
            System.out.println("CLL is Empty");
            return;
        }

        System.out.println("Enter Node value to delete >> ");
        int value = scanner.nextInt();

        Node temp = head;
        Node prev = null;

        do {
            if (temp.data == value) {
                if (temp == head) {
                    if (temp.next == head) {
                        head = null;
                    } else {
                        head = temp.next;
                        Node lastNode = head;
                        while (lastNode.next != temp) {
                            lastNode = lastNode.next;
                        }
                        lastNode.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Node deleted successfully");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node with the specified value not found. Deletion failed.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("HEAD -> ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println(" HEAD");
    }

    public void count() {
        if (head == null) {
            System.out.println("Total 0 nodes are present");
            return;
        }

        Node temp = head;
        int count = 0;

        do {
            temp = temp.next;
            count++;
        } while (temp != head);

        System.out.println("Total " + count + " nodes are present");
    }

    public void reverse() {
        if (head == null || head.next == head) {
            System.out.println("List is empty or has only one node. No reversal needed.");
            return;
        }

        System.out.println("List Before reversed successfully");
        display();
        System.out.println();

        Node prev = null;
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head = prev;

        System.out.println("List reversed successfully");
        display();
    }

    public void rotate() {
        Scanner scanner = new Scanner(System.in);
        if (head == null || head.next == head) {
            System.out.println("\nRotation not possible");
            return;
        }

        System.out.println("Enter the number of positions to rotate >> ");
        int k = scanner.nextInt();

        if (k == 0) {
            System.out.println("No rotation performed ");
            return;
        }

        Node temp = head;
        int count = 1;

        do {
            temp = temp.next;
            count++;
        } while (temp.next != head);

        temp.next = head;

        for (int i = 0; i < k % count; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = head;

        System.out.println("List rotated successfully");
    }
}

public class CLL {
    public static void main(String[] args) {
        CLLx x = new CLLx();
        int ch = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    x.insert();
                    break;
                case 2:
                    x.search();
                    break;
                case 3:
                    x.delete();
                    break;
                case 4:
                    x.display();
                    break;
                case 5:
                    x.count();
                    break;
                case 6:
                    x.reverse();
                    break;
                case 7:
                    x.rotate();
                    break;
            }
        } while (ch != 8);
    }
} 