package DSA.Stack.LinkedListStack;

import java.util.Scanner;

class Node {
    public int data;
    public Node next;

    public Node(int value) {
        data = value;
        next = null;
    }
}

class LinkedList1 {
    private Node head;

    public LinkedList1() {
        head = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int poppedValue = head.data;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return poppedValue;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println("Top Element is >> " + head.data);
        return head.data;
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Number of Stack Elements is >> " + count);
        return count;
    }

    public void destroy() {
        while (head != null) {
            pop();
        }
        System.out.println("Stack Destroyed");
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack is not Empty");
        }
        return head == null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch = 0, data = 0;
        LinkedList1 x = new LinkedList1();
        do {
            System.out.println("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter data >> ");
                    data = scanner.nextInt();
                    x.push(data);
                    break;
                case 2:
                    x.pop();
                    break;
                case 3:
                    x.peek();
                    break;
                case 4:
                    x.isEmpty();
                    break;
                case 6:
                    x.count();
                    break;
                case 7:
                    x.destroy();
                    break;
                case 8:
                    x.display();
                    break;
            }
        } while (ch != 9);
        scanner.close();
    }
}
