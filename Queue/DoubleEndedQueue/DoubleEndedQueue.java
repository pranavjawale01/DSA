package DSA.Queue.DoubleEndedQueue;

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;
    Node(int value) {
        data = value;
        prev = null;
        next = null;
    }
}
class DoubleEndedQueue {
    Node front, rear;
    DoubleEndedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void addToFront(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void addToLast(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }
        int value = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return value;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }
        int value = rear.data;
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        return value;
    }

    public void print() {
        System.out.print("NULL");
        Node temp = front;
        while (temp != null) {
            System.out.print(" <-> " + temp.data);
            temp = temp.next;
        }
        System.out.print(" <-> NULL");
    }

    public int size() {
        Node temp = front;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        DoubleEndedQueue deque = new DoubleEndedQueue();
        Scanner scanner = new Scanner(System.in);
        int ch, data;

        do {
            System.out.println("\n1. Insert at Front\n2. Insert at Last\n3. Remove from Front\n4. Remove from Last\n5. Print\n6. Size\n7. Exit");
            System.out.print("Enter your choice: ");
            ch = scanner.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Enter the element to insert at the front: ");
                        data = scanner.nextInt();
                        deque.addToFront(data);
                        break;

                    case 2:
                        System.out.print("Enter the element to insert at the last: ");
                        data = scanner.nextInt();
                        deque.addToLast(data);
                        break;

                    case 3:
                        data = deque.removeFirst();
                        System.out.println("Removed element is " + data);
                        break;

                    case 4:
                        data = deque.removeLast();
                        System.out.println("Removed element is " + data);
                        break;

                    case 5:
                        deque.print();
                        break;

                    case 6:
                        System.out.println("Size of deque: " + deque.size());
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (ch != 7);
        scanner.close();
    }
}