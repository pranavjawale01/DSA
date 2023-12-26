package DSA.Queue.LinearQueue;

import java.util.Scanner;

class LinearQueuex {
    private static final int MAX_SIZE = 100;
    private int[] arr = new int[MAX_SIZE];
    private int front, rear;

    public LinearQueuex() {
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("\nQueue is Full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }
        arr[rear] = element;
        System.out.println("Enqueued : " + element);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println("Dequeued : " + arr[front]);
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nQueue is Empty");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.print(" [" + arr[i] + "] ");
            i = (i + 1) % MAX_SIZE;
        }
        System.out.println(" [" + arr[rear] + "] ");
    }
}

public class LinearQueue {
    public static void menu() {
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        LinearQueuex x = new LinearQueuex();
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        while (true) {
            menu();
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    int element;
                    System.out.print("Enter element to enqueue: ");
                    element = scanner.nextInt();
                    x.enqueue(element);
                    break;
                case 2:
                    x.dequeue();
                    break;
                case 3:
                    x.display();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
            }
        }
    }
}
