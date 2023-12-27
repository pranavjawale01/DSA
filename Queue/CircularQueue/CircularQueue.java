package DSA.Queue.CircularQueue;

import java.util.Scanner;

public class CircularQueue {
    private int rear;
    private int front;
    private int[] arr;

    public CircularQueue(int size) {
        rear = -1;
        front = -1;
        arr = new int[size];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
            System.out.println("Data Added");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            front = (front + 1) % arr.length;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("<-");
            for (int i = front; i <= rear; i++) {
                System.out.print(" [" + arr[i] + "] ");
            }
            System.out.println("->");
        }
    }

    public boolean isFull() {
        return (rear + 1) % arr.length == front;
    }

    public boolean isEmpty() {
        return rear == front && rear == -1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (front <= rear) {
            return rear - front + 1;
        } else {
            return arr.length - front + rear + 1;
        }
    }

    public void clear() {
        rear = -1;
        front = -1;
        System.out.println("Queue cleared");
    }

    public static void main(String[] args) {
        CircularQueue x = new CircularQueue(100);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Enqueue \n2.Dequeue \n3.Display \n4.Size \n5.Clear \n6.Exit");
            int ch = scanner.nextInt();

            if (ch == 1) {
                System.out.print("Enter the data >> ");
                int data = scanner.nextInt();
                x.enqueue(data);
            } else if (ch == 2) {
                x.dequeue();
            } else if (ch == 3) {
                x.display();
            } else if (ch == 4) {
                System.out.println("Size: " + x.size());
            } else if (ch == 5) {
                x.clear();
            } else if (ch == 6) {
                break;
            }
        }
        
        scanner.close();
    }
}