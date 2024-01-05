package DSA.Queue.DoublyEndedPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DEPQ {
    private static final int INITIAL_CAPACITY = 10;
    private Node[] data;
    private int front;
    private int back;
    private int capacity;

    private static class Node {
        Object value;
        int priority;

        Node(Object value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    public DEPQ() {
        data = new Node[INITIAL_CAPACITY];
        front = 0;
        back = 0;
        capacity = INITIAL_CAPACITY;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node[] newData = new Node[newCapacity];
        System.arraycopy(data, 0, newData, 0, front);
        System.arraycopy(data, capacity - back, newData, newCapacity - back, back);

        data = newData;
        capacity = newCapacity;
    }

    public void print() {
        System.out.println("\nFront Heap : ");
        for (int i = 0; i < front; i++) {
            System.out.print(" (" + data[i].value + ", " + data[i].priority + ") ");
        }
        System.out.println("\nBack Heap : ");
        for (int i = capacity - back; i < capacity; i++) {
            System.out.print(" (" + data[i].value + ", " + data[i].priority + ") ");
        }
        System.out.println();
    }

    public void pushFront(Object value, int priority) {
        if (front == capacity / 2) {
            resize();
        }
        data[front++] = new Node(value, priority);
        Arrays.sort(data, 0, front, (a, b) -> Integer.compare(b.priority, a.priority));
        print();
    }

    public void pushBack(Object value, int priority) {
        if (back == capacity / 2) {
            resize();
        }
        data[capacity - ++back] = new Node(value, priority);
        Arrays.sort(data, capacity - back, capacity, Comparator.comparingInt(a -> ((Node) a).priority));
        print();
    }

    public Object popFront() {
        if (front == 0) {
            return null;
        }
        Arrays.sort(data, 0, front, (a, b) -> Integer.compare(((Node) b).priority, ((Node) a).priority));
        Object value = ((Node) data[--front]).value;
        print();
        return value;
    }

    public Object popBack() {
        if (back == 0) {
            return null;
        }
        Arrays.sort(data, capacity - back, capacity, Comparator.comparingInt(a -> ((Node) a).priority));
        Object value = ((Node) data[capacity - back--]).value;
        print();
        return value;
    }
}

class doublyEndedPriorityQueue {
    public static void main(String[] args) {
        DEPQ depq = new DEPQ();

        Scanner scanner = new Scanner(System.in);
        int ch, data, priority;

        do {
            System.out.println("\n1. Push Front\n2. Push Back\n3. Pop Front\n4. Pop Back\n5. Print\n6. Exit");
            System.out.print("Enter your choice: ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter data and priority: ");
                    data = scanner.nextInt();
                    priority = scanner.nextInt();
                    depq.pushFront(data, priority);
                    break;

                case 2:
                    System.out.print("Enter data and priority: ");
                    data = scanner.nextInt();
                    priority = scanner.nextInt();
                    depq.pushBack(data, priority);
                    break;

                case 3:
                    System.out.println("Popped from front: " + depq.popFront());
                    break;

                case 4:
                    System.out.println("Popped from back: " + depq.popBack());
                    break;

                case 5:
                    depq.print();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (ch != 6);
        scanner.close();
    }
}
